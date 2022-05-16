package com.example.fyp.Controller;

import com.example.fyp.Entity.Product;
import com.example.fyp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping
    public List<Product> getProducts(){
        return  productService.getProducts();
    }


    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProduct(id);}

    @PostMapping
    public ResponseEntity<?> addProduct(@Valid @RequestBody Product product, BindingResult result) {
        if (result.hasErrors()) {

            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
        }
        Product p = productService.addProduct(product);
        return new ResponseEntity<Product>(p, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);

    }

}
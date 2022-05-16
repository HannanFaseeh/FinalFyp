package com.example.fyp.Service;

import com.example.fyp.Entity.Product;
import com.example.fyp.Repository.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRep productRep;


    public List<Product> getProducts()
    {
        return productRep.findAll();
    }

    public Product getProduct(int id){
        Optional<Product> product = productRep.findById(id);
        if(!product.isPresent()){
            //throw new NotFoundException("product not found!");
        }
        return product.get();
    }

    public Product addProduct(Product product){
        productRep.save(product);
        return product;
    }

    public Product updateProduct(int id,Product product){
        product.setProductId(id);
        productRep.save(product);
        return product;
    }

    public void deleteProduct(int id){
        productRep.deleteById(id);
    }
}
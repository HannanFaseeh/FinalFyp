package com.example.fyp.Service;

import com.example.fyp.Entity.Admin;
import com.example.fyp.Exceptions.NotFoundException;
import com.example.fyp.Repository.AdminRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
        @Autowired
        private AdminRep adminRep;

        public List<Admin> getAdmins(){return adminRep.findAll();}

        public Admin getAdmin(int id){
            Optional<Admin> admin = adminRep.findById(id);
            if(!admin.isPresent()){
                throw new NotFoundException("Admin not found!");
            }
            return admin.get();
        }
        public Admin addAdmin(Admin admin){
            adminRep.save(admin);
            return admin;
        }
        public Admin updateAdmin(int id,Admin admin){
            admin.setId(id);
            adminRep.save(admin);
            return admin;
        }
        public void deleteAdmin(int id){
            adminRep.deleteById(id);
        }

}

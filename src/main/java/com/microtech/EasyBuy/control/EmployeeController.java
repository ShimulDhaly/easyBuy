package com.microtech.EasyBuy.control;

import com.microtech.EasyBuy.entity.Employee;
import com.microtech.EasyBuy.repository.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
   @Autowired
   RepositoryEmployee repositoryEmployee;

    @PostMapping("/insert")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>("employee added successfully", HttpStatus.CREATED);

    }



}

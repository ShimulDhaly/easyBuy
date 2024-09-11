package com.microtech.EasyBuy.control;

import com.microtech.EasyBuy.entity.Employee;
import com.microtech.EasyBuy.repository.RepositoryEmployee;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
   @Autowired
   RepositoryEmployee repositoryEmployee;

    @PostMapping("/insert")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        repositoryEmployee.save(employee);
      return new ResponseEntity<>("employee addded successfully",HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<Employee> getEmployeeById(@RequestParam Integer id) {
        Employee employee = repositoryEmployee.findById(id).orElse(null);
        if (employee != null) {
            return ResponseEntity.ok(employee);

        } else {
            return ResponseEntity.notFound().build();
        }
    }
       @GetMapping("/allemp")
    public List<Employee>getAllEmployee(){
        return repositoryEmployee.findAll();
       }
       @PostMapping("/{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable Integer id,@RequestBody Employee updateemployee){
        Employee employee = repositoryEmployee.findById(id).orElse(null);
        if (employee != null){
            employee.setName(updateemployee.getName());
            employee.setAddress(updateemployee.getAddress());
            employee.setAge(updateemployee.getAge());
            repositoryEmployee.save(employee);
            return ResponseEntity.ok(employee);
        }else {
            return ResponseEntity.noContent().build();
        }

       }
       @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteById(@PathVariable Integer id) {
           if (repositoryEmployee.existsById(id)) {
               repositoryEmployee.deleteById(id);
               return ResponseEntity.noContent().build();
           } else {
               return ResponseEntity.notFound().build();
           }


       }


}

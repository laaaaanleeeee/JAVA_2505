package com.data.controller;

import com.data.dto.*;
import com.data.entity.Department;
import com.data.entity.Employee;
import com.data.repository.DepartmentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Setter
@RestController
@RequestMapping("departments")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentController {

    // c1 dùng @Autowired
//    @Autowired
//    DepartmentRepository departmentRepo;

    // c2
//    DepartmentRepository departmentRepo;
//    public DepartmentController(DepartmentRepository departmentRepo) {
//        this.departmentRepo = departmentRepo;
//    }

    // c3
//    DepartmentRepository departmentRepo;
//    @Autowired
//    public DepartmentController(DepartmentRepository departmentRepo) {
//        this.departmentRepo = departmentRepo;
//    }


    // c4
    final DepartmentRepository departmentRepo;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Department> departments = departmentRepo.findAll();
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        departments.forEach(department -> {
//            System.out.println(department.getId());
//            System.out.println(department.getDepartmentName());

            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setId(department.getId());
            departmentDTO.setDepartmentName(department.getDepartmentName());
            departmentDTO.setAddress(department.getAddress());

            List<Employee> employees = department.getEmployees();

            // set list username
            List<String> usernames = new ArrayList<>();

            employees.forEach(employee -> {
                usernames.add(employee.getUsername());
            });

            departmentDTO.setUsernames(usernames);
            departmentDTOS.add(departmentDTO);
        });


        // trả về size, trả về departments lỗi
        // TH1: trả về entity có MQH (1n, 11, nn)
        // TH2: print entity có MQH (1n, 11, nn)

        // Khắc phục: Trả về DTO thì OK
        return ResponseEntity.ok(departmentDTOS);



    }

    @GetMapping("get2")
    public ResponseEntity<?> get2() {
        List<Department> departments = departmentRepo.findAll();
        List<DepartmentDTO2> departmentDTO2s = new ArrayList<>();
        departments.forEach(department -> {
//            System.out.println(department.getId());
//            System.out.println(department.getDepartmentName());

            DepartmentDTO2 departmentDTO2 = new DepartmentDTO2();
            departmentDTO2.setId(department.getId());
            departmentDTO2.setDepartmentName(department.getDepartmentName());
            departmentDTO2.setAddress(department.getAddress());

            List<Employee> employees = department.getEmployees();

            // set list username
            List<EmployeeDTO> employeeDTOS = new ArrayList<>();

            employees.forEach(employee -> {
                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.setId(employee.getId());
                employeeDTO.setUsername(employee.getUsername());
                employeeDTO.setPassword(employee.getPassword());

                employeeDTOS.add(employeeDTO);
            });

            departmentDTO2.setEmployeeDTOS(employeeDTOS);
            departmentDTO2s.add(departmentDTO2);
        });
        return ResponseEntity.ok(departmentDTO2s);
    }


    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody DepartmentCreateDTO departmentCreateDTO) {
        Department department = new Department();
        department.setDepartmentName(departmentCreateDTO.getDepartmentName());
        department.setAddress(departmentCreateDTO.getAddress());

        departmentRepo.save(department);
        return new ResponseEntity<>("tao thanh cong", HttpStatus.OK);

    }


    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DepartmentUpdateDTO departmentUpdateDTO) {
        Optional<Department> optionalDepartment =departmentRepo.findById(id);

        if(optionalDepartment.isEmpty()) {
            return new ResponseEntity<>("Loi", HttpStatus.BAD_REQUEST);
        }

        Department department = optionalDepartment.get();
        department.setDepartmentName(departmentUpdateDTO.getDepartmentName());
        department.setAddress(departmentUpdateDTO.getAddress());

        departmentRepo.save(department);
        return new ResponseEntity<>("cap nhat thanh cong", HttpStatus.OK);

    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<Department> optionalDepartment =departmentRepo.findById(id);
        if(optionalDepartment.isEmpty()) {
            return new ResponseEntity<>("Id not found", HttpStatus.BAD_REQUEST);
        }

        Department department = optionalDepartment.get();
        departmentRepo.delete(department);

        return new ResponseEntity<>("Xoa thanh cong", HttpStatus.OK);
    }
}

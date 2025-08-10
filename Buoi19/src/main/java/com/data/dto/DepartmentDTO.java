package com.data.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentDTO {

    int id;

    String departmentName;

    String address;

    // TH1: lưu nhiều username của employee: List<String>
    List<String> usernames;



    // TH2: lưu nhiều đối tượng thông tin employee: List<EmployeeDTO>


}

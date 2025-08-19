package com.example.demo_thymeleaf.dto;

import com.example.demo_thymeleaf.entity.Product;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageDTO<T> {
    List<T> listDTO;

    int page;

    int totalPage;

    int size;

    int numElement;

    long totalElement;

    boolean isFirst;

    boolean isLast;

}

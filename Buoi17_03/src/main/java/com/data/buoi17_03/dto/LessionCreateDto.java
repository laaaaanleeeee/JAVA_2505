package com.data.buoi17_03.dto;

import com.data.buoi17_03.entity.LessionTypeEnum;
import lombok.Data;

import java.util.Date;

@Data
public class LessionCreateDto {
    private String lessionName;
    private int lessionHours;
    private LessionTypeEnum lessionType;
    private Date createdDate;
}

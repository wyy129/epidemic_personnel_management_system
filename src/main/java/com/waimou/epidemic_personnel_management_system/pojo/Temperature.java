package com.waimou.epidemic_personnel_management_system.pojo;

import lombok.Data;
import lombok.ToString;


@ToString
@Data
public class Temperature {
    private Integer isRisk;

    private String temperature;


    private String datetime;


    private Integer userId;
}

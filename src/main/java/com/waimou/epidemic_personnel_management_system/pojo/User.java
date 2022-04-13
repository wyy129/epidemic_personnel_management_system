package com.waimou.epidemic_personnel_management_system.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/9 11:56
 * @description 标题
 * @package com.itheima.pojo
 */
@ToString
@Data
public class User implements Serializable {
    private Integer id;
    private String phone;
    private Integer organization_id;
    private Integer project_id;

}

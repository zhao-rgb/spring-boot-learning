package com.soft1851.springboot.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (SysRole)实体类
 *
 * @author zxl
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = -67337684330709533L;
    /**
    * 角色id
    */
    private Integer roleId;
    /**
    * 角色名词
    */
    private String roleName;
    /**
    * 描述
    */
    private String description;
}
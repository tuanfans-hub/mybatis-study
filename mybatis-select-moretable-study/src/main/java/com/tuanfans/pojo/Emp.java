package com.tuanfans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author TuanFans
 * @date 2025/5/7
 * @description
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Emp implements Serializable {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private LocalDate hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
    // 组合属性，封装部门信息
    private Dept dept;
}

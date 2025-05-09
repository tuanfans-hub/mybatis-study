package com.tuanfans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author TuanFans
 * @date 2025/5/9
 * @description
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProAndEmp implements Serializable {
    private Integer empno;
    private Integer pid;

    //组合属性：封装了员工的信息
    private Emp emp;
}

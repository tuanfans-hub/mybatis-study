package com.tuanfans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/7
 * @description
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc;

    // 关联的集合,封装该部门的员工集合
    private List<Emp> emps;
}

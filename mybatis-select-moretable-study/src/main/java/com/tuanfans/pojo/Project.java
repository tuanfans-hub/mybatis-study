package com.tuanfans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/9
 * @description
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project implements Serializable {
    private Integer pid;
    private String pname;
    private String money;

    //组合属性：封装了项目与员工的关系的信息
    private List<ProAndEmp> proAndEmp;
}

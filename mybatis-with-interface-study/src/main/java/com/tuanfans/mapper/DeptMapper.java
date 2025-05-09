package com.tuanfans.mapper;

import com.tuanfans.pojo.Dept;

/**
 * @author TuanFans
 * @date 2025/5/8
 * @description
 */
public interface DeptMapper {
    /**
     * 添加部门
     * @param dept 封装部门信息的对象
     * @return 影响行数
     */
    int addDept(Dept dept);

    /**
     * 根据部门编号删除部门信息
     * @param deptno 部门编号
     * @return 影响行数
     */
    int deleteDept(Integer deptno);

    /**
     * 根据部门编号修改部门信息
     * @param dept 封装部门信息的对象
     * @return 影响行数
     */
    int updateDept(Dept dept);
}

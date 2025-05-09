package com.tuanfans.mapper;

import com.tuanfans.pojo.Dept;
import com.tuanfans.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/9
 * @description
 */
public interface DeptMapper {
    Dept findDeptByDeptno(Integer deptno);

    /**
     * 根据部门编号查询员工信息并携带其所在的部门信息（嵌套结果）
     * @param deptno 部门编号
     * @return 员工信息并携带其所在的部门信息
     */
    List<Dept> findDeptJoinEmpByDeptno(@Param("deptnos")List<Integer> deptno);

    /**
     * 根据部门编号查询员工信息并携带其所在的部门信息(嵌套查询)
     * @param deptno 部门编号
     * @return 员工信息并携带其所在的部门信息
     */
    List<Dept> findDeptJoinEmpByDeptno2(@Param("deptnos")List<Integer> deptno);
}

package com.tuanfans.mapper;

import com.tuanfans.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/8
 * @description
 */
public interface EmpMapper {
    /**
     * 查询所有员工
     * @return 所有员工信息的集合
     */
    List<Emp> findAll();

    /**
     * 根据多个部门编号查询员工信息
     * @param deptno 部门编号
     * @return 员工信息
     */
    List<Emp> findEmpByDeptnos(@Param("deptnos")List<Integer> deptnos);

    /**
     * 根据部门编号查询员工信息并携带
     * @param deptno 部门编号
     * @return 员工信息
     */
    List<Emp> findEmpByDeptno(Integer deptno);

    /**
     * 根据员工编号查询员工信息并携带其所在的部门信息（嵌套结果）
     * @param empno 员工编号
     * @return 员工信息并携带其所在的部门信息
     */
    Emp findEmpJoinDeptByEmpno(Integer empno);

    /**
     * 根据员工编号查询员工信息并携带其所在的部门信息（嵌套查询）
     * @param empno 员工编号
     * @return 员工信息并携带其所在的部门信息
     */
    Emp findEmpJoinDeptByEmpno2(Integer empno);


}

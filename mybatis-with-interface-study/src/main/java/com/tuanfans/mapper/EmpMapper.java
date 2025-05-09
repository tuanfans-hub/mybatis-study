package com.tuanfans.mapper;

import com.tuanfans.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author TuanFans
 * @date 2025/5/7
 * @description
 */
public interface EmpMapper {
    /**
     * 查询所有员工
     * @return 所有员工的集合
     */
    List<Emp> findAll();

    /**
     * 根据员工编号查询员工
     * @param empno
     * @return 查询到的员工信息
     */
    Emp findEmpById(Integer empno);

    /**
     * 根据部门编号和工资查询员工
     * @param deptno
     * @param sal
     * @return 查询到的员工集合
     * 可以使用@Param("deptno")指定参数名称
     */
    List<Emp> findEmpByDeptAndSal(@Param("deptno")Integer deptno, @Param("sal")Double sal);

    /**
     * 根据部门编号和工资查询员工（使用Map集合封装信息）
     * @param map 封装了部门编号和工资的map集合
     * @return 查询到的员工集合
     */
    List<Emp> findEmpByDeptAndSal2(Map<String,Object> map);

    /**
     * 根据部门编号和工资查询员工（使用一个对象封装信息）
     * @param emp 封装了部门编号和工资的对象
     * @return 查询到的员工集合
     */
    List<Emp> findEmpByDeptAndSal3(Emp emp);

    /**
     * 根据部门编号和工资查询员工（使用两个对象封装信息）
     * @param emp1 封装了部门编号信息的对象
     * @param emp2 封装了工资信息的对象
     * @return 查询到的员工集合
     */
    List<Emp> findEmpByDeptAndSal4(@Param("emp1")Emp emp1,@Param("emp2")Emp emp2);

    /**
     * 根据员工姓名模糊匹配查询员工
     * @param ename 模糊名称
     * @return 查询到的员工集合
     */
    List<Emp> findEmpByName(String ename);

    /**
     * 根据emp中不为null值的属性查询员工
     * @param emp 员工信息
     * @return 查询到的员工集合
     */
    List<Emp> findEmpByCondition(Emp emp);

    /**
     * 根据工号修改emp中不为null值的属性信息
     * @param emp
     * @return 修改的行数
     */
    int updateEmpByCondition(Emp emp);

    /**
     * 根据部门编号查询员工
     * @param deptnos 部门编号集合
     * @return 查询到的员工集合
     */
    List<Emp> findEmpByMoreDept(@Param("deptnos")List<Integer> deptnos);
}

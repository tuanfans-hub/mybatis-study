package com.tuanfans.mapper;

import com.tuanfans.pojo.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/9
 * @description
 */
public interface ProjectMapper {
    /**
     * 根据项目编号查询项目信息及项目关联的员工信息
     * @param pids 项目编号集合
     * @return 项目信息及项目关联的员工信息
     */
    List<Project> findProJoinEmpsByPid(@Param("pids")List<Integer> pids);
}

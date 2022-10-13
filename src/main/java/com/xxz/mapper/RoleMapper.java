package com.xxz.mapper;


import com.xxz.bean.EmpRole;
import com.xxz.bean.Menu;
import com.xxz.bean.Role;
import com.xxz.bean.vo.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface RoleMapper {

    List<Role> selectAllRole();

    int insertRole(Role role);

    int deleteRoleById(@Param("id") String id);

    Role selectRoleById(@Param("id")String id);

    int updateRoleById(Role role);

    int selectRoleCountByEmpId(@Param("empId")String empId);

    int deleteRoleListByEmpId(@Param("empId")String empId);

    int insertRoleList(ArrayList<EmpRole> empRoles);

    List<Role> selectAllRoleByEmpId(@Param("empId")String empId);

    List<MenuVo> selectAllRoleOfMenu();

    List<MenuVo> selectAllRoleOfMenuByRoleId(@Param("roleId") String roleId);

    int selectRoleOfMenuByRoleId(@Param("roleId")String roleId);

    int deleteRoleOfMenuByRoleId(@Param("roleId")String roleId);

    int insertRoleOfMenu(ArrayList roleMenus);

    String selectMenuIdByCurCode(@Param("curCode")String curCode);

    List<String> selectAllMenuByEmpId(@Param("empId")Integer empId);
}
package com.xxz.service;

import com.xxz.bean.EmpRole;
import com.xxz.bean.Menu;
import com.xxz.bean.Role;
import com.xxz.bean.vo.MenuVo;
import com.xxz.exception.AsyncResp;
import com.xxz.mapper.RoleMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleService implements ApplicationContextAware {

    @Resource
    private RoleMapper roleMapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Role> queryAllRole(){
        return roleMapper.selectAllRole();
    }

    public int saveRole(Role role){
        return roleMapper.insertRole(role);
    }


    public int removeRoleById(String id) {
        return roleMapper.deleteRoleById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Role queryRoleById(String id) {
        return roleMapper.selectRoleById(id);
    }

    public int modifyRoleById(Role role) {
        return roleMapper.updateRoleById(role);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int queryRoleCountByEmpId(String empId) {
        return roleMapper.selectRoleCountByEmpId(empId);
    }

    public int removeRoleListByEmpId(String empId) {
        return roleMapper.deleteRoleListByEmpId(empId);
    }

    /**
     *  如果当前员工有分配角色，则删除全部角色再添加，没有分配角色就直接添加
     * @param empRoles
     * @param empId
     * @return
     */
    public int saveRoleList(ArrayList<EmpRole> empRoles,String empId) {
        //手动从工厂中获取代理对象来保证事务的有效性
        RoleService roleService = applicationContext.getBean("roleService", RoleService.class);
        int roleCount = roleService.queryRoleCountByEmpId(empId);
        if (roleCount > 0) {
            roleService.removeRoleListByEmpId(empId);
        }
        return roleMapper.insertRoleList(empRoles);
    }

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 根据角色id修改角色拥有的资源
     * 先查询该角色拥有的资源，如果有则全部删除再添加，没有就直接添加
     * @param roleMenus
     * @param roleId
     * @return
     */
    public void modifyMenuByRoleId(ArrayList roleMenus, String roleId) {
        RoleService roleService = applicationContext.getBean("roleService", RoleService.class);

        //查询角色拥有的资源
        int count = roleService.queryRoleOfMenuByRoleId(roleId);

        //拥有资源就全部删除重新添加
        if(count > 0){
            roleService.removeRoleOfMenuByRoleId(roleId);
        }
        roleMapper.insertRoleOfMenu(roleMenus);
    }

    public int removeRoleOfMenuByRoleId(String roleId) {
        return roleMapper.deleteRoleOfMenuByRoleId(roleId);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int queryRoleOfMenuByRoleId(String roleId) {
        return roleMapper.selectRoleOfMenuByRoleId(roleId);
    }


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Role> queryAllRoleByEmpId(String empId) {
        return roleMapper.selectAllRoleByEmpId(empId);
    }


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<MenuVo> queryAllRoleOfMenu() {
        return roleMapper.selectAllRoleOfMenu();
    }


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<MenuVo> queryAllRoleOfMenuByRoleId(String roleId) {
        return roleMapper.selectAllRoleOfMenuByRoleId(roleId);
    }


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public String queryMenuIdByCurCode(String curCode) {
        return roleMapper.selectMenuIdByCurCode(curCode);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public  List<String> queryAllMenuByEmpId(Integer empId) {
        return roleMapper.selectAllMenuByEmpId(empId);
    }
}

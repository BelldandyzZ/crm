package com.xxz.controller;


import com.xxz.bean.EmpRole;
import com.xxz.bean.Menu;
import com.xxz.bean.Role;
import com.xxz.bean.RoleMenu;
import com.xxz.bean.vo.MenuVo;
import com.xxz.exception.AsyncResp;
import com.xxz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/permission/")
public class RoleController {

    @Resource
    private RoleService roleService;

    @Resource
    private MenuService menuService;

    @Autowired
    private EmpService empService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DicValueService dicValueService;

    /**
     * 查询所有角色
     * @param model
     * @return
     */
    @RequestMapping("findAllRole")
    public String findAllRole(Model model, HttpSession session){


//=====================================================================================================


        List<Role> roleList = roleService.queryAllRole();
        model.addAttribute("roleList",roleList);
        return "permission/index";
    }


    /**
     * 添加角色，添加完成调用查询方法然后返回页面渲染
     * @param role
     * @return
     */
    @RequestMapping("addRole")
    public String addRole(Role role){
        roleService.saveRole(role);
        return "redirect:/permission/findAllRole";
    }


    /**
     * 删除角色，删除完成调用查询方法返回页面渲染
     * @param id
     * @return
     */
    @RequestMapping("eraseRole/{id}")
    public String eraseRole(@PathVariable("id") String id){
        roleService.removeRoleById(id);
        return "redirect:/permission/findAllRole";
    }


    /**
     * 修改角色信息时的数据回显
     * @param id
     * @return
     */
    @RequestMapping("toEditRole/{id}")
    @ResponseBody
    public AsyncResp toEditRole(@PathVariable("id") String id){
        Role role = roleService.queryRoleById(id);
        AsyncResp resp = AsyncResp.success(role);
        return resp;
    }

    /**
     * 修改角色的方法
     * @param role
     * @return
     */
    @RequestMapping("editRole")
    @ResponseBody
    public AsyncResp editRole(Role role){
        int res = roleService.modifyRoleById(role);
        AsyncResp resp = AsyncResp.success(role, AsyncResp.UPDATE_SUCCESS);
        return resp;
    }

    /**
     * 查询当前用户拥有的菜单权限
     *
     * @return
     */
    @RequestMapping("findCurrentEmpOfMenu/{id}")
    @ResponseBody
    public AsyncResp findCurrentEmpOfMenu(@PathVariable("id") String empId){
        //先查询所有的资源菜单
        List<Menu> menuList = menuService.queryAllMenu();
        return AsyncResp.success(menuList);
    }


    /**
     * 查询所有菜单资源，在根据角色id查询该该角色拥有的菜单资源
     * @param roleId
     * @return
     */
    @RequestMapping("findAllMenu/{roleId}")
    @ResponseBody
    public AsyncResp findAllMenu(@PathVariable("roleId") String roleId){

        //所有的菜单资源
        List<MenuVo> menuVoList = roleService.queryAllRoleOfMenu();

        //当前角色拥有的菜单资源
        List<MenuVo> roleMenus = roleService.queryAllRoleOfMenuByRoleId(roleId);


        //判断哪些是角色已经有的资源，设置true在前端做默认选中
        if(roleMenus != null && roleMenus.size() > 0){
            for (MenuVo menuVo : menuVoList) {
                for (MenuVo menu : roleMenus) {
                    if(menuVo.getId().equals(menu.getId())){
                        menuVo.setChecked(true);
                        break;
                    }
                }
            }
        }
        return AsyncResp.success(menuVoList);
    }

    /**
     * 根据角色id修改角色拥有的资源
     * 先查询该角色拥有的资源，如果有则全部删除再添加，没有就直接添加
     * @param roleId
     * @param curCodes :并不是菜单id，而是菜单的cur_code
     * @return
     */
    @RequestMapping("editPermissions")
    @ResponseBody
    public AsyncResp editPermissions(String roleId,@RequestParam("id") String[] curCodes){

        //根据每个菜单的curCode查询出对应的id
        ArrayList roleMenus = new ArrayList<RoleMenu>(16);
        for (String curCode : curCodes) {
            String id = roleService.queryMenuIdByCurCode(curCode);
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setmId(id);
            roleMenu.setrId(roleId);
            roleMenus.add(roleMenu);
        }


         roleService.modifyMenuByRoleId(roleMenus,roleId);
         return AsyncResp.success(AsyncResp.ADD_SUCCESS);
    }


}

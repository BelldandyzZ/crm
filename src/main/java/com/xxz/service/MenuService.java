package com.xxz.service;

import com.xxz.bean.Menu;
import com.xxz.mapper.MenuMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> queryAllMenu(){
        List<Menu> menuList = menuMapper.selectAllMenu();
        return  menuList;
    }

}

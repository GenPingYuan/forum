package com.forum.iweb.controller;

import com.forum.common.annotation.Logger.MyLogger;
import com.forum.common.json.util.JsonUtil;
import com.forum.entity.dto.enums.Display;
import com.forum.entity.dto.enums.State;
import com.forum.entity.dto.menu.Menu;
import com.forum.entity.dto.menu.MenuCatalog;
import com.forum.jdbc.Repository.menu.MenuCatalogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@MyLogger(value = "菜单")
@RestController
@RequestMapping("/menu")
public class MenuController {

    private Logger _log = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuCatalogRepository menuCatalogRepository;

    /**
     * 有过滤条件的列表
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/filterList")
    public String filterListMenu() throws Exception {
        List<MenuCatalog> menuCatalogList = menuCatalogRepository.findAllByIsShowAndMenuCatalogStateOrderBySort(Display.SHOW.getValue(), State.VALID.getValue());
        return JsonUtil.getInstance().writeValueAsString(menuCatalogList);
    }

    @ResponseBody
    @RequestMapping("/addCatalog")
    // TODO
    public String saveMenuCatalog(){
        MenuCatalog menuCatalog = new MenuCatalog();
        menuCatalog.setCatalogName("首页");
        menuCatalog.setUrl("/");
        menuCatalog.setSort(1);

        menuCatalogRepository.save(menuCatalog);
        return "success";
    }



}

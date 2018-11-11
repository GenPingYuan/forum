package com.forum.entity.dto.menu;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.forum.entity.dto.BaseEntity;
import com.forum.entity.dto.enums.Display;
import com.forum.entity.dto.enums.State;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Menu extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -2258221144623660618L;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_url")
    private String menuUrl;

    // 菜单顺序
    @Column
    private int sort;

    //是否展示
    @Column(name = "is_show")
    private int isShow = Display.SHOW.getValue();

    //菜单状态
    @Column(name = "menu_state")
    private String menuState = State.VALID.getValue();

    //上层菜单
    @ManyToOne(fetch=FetchType.LAZY, targetEntity = MenuCatalog.class)
    @JoinColumn(name = "parent_id")
    private MenuCatalog parentId;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(Display display) {
        this.isShow = display.getValue();
    }

    public String getMenuState() {
        return menuState;
    }

    public void setMenuState(State state) {
        this.menuState = state.getValue();
    }

    public MenuCatalog getParentId() {
        return parentId;
    }

    public void setParentId(MenuCatalog parentId) {
        this.parentId = parentId;
    }
}

package com.forum.entity.dto.menu;

import com.forum.entity.dto.BaseEntity;
import com.forum.entity.dto.enums.Display;
import com.forum.entity.dto.enums.State;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "menu_catalog")
public class MenuCatalog extends BaseEntity implements Serializable{
    private static final long serialVersionUID = -4518822088323913267L;

    @Column(name = "catalog_name")
    private String catalogName;

    @Column
    private String url;

    @Column
    private int sort;

    @Column(name = "is_show")
    private int isShow = Display.SHOW.getValue();

    @Column(name = "menu_catalog_state")
    private String menuCatalogState = State.VALID.getValue();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "parentId")
    private Set<Menu> subMenu = new HashSet<Menu>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getMenuCatalogState() {
        return menuCatalogState;
    }

    public void setMenuCatalogState(State state) {
        this.menuCatalogState = state.getValue();
    }

    public Set<Menu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(Set<Menu> subMenu) {
        this.subMenu = subMenu;
    }
}

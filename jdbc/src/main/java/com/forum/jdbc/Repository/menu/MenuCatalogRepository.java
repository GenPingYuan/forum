package com.forum.jdbc.Repository.menu;

import com.forum.entity.dto.enums.Display;
import com.forum.entity.dto.enums.State;
import com.forum.entity.dto.menu.MenuCatalog;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuCatalogRepository extends JpaRepository<MenuCatalog,Long> {

    public List<MenuCatalog> findAllByIsShowAndMenuCatalogStateOrderBySort(int show, String state);
}

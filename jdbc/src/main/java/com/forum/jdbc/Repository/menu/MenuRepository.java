package com.forum.jdbc.Repository.menu;

import com.forum.entity.dto.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface MenuRepository extends JpaRepository<Menu,Long>{

}

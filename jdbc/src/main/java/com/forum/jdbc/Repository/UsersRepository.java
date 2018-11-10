package com.forum.jdbc.Repository;


import com.forum.entity.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public interface UsersRepository extends JpaRepository<User,Long>{

}

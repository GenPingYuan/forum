package com.forum.jdbc.Repository.User;


import com.forum.entity.dto.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface UsersRepository extends JpaRepository<User,Long>{

}

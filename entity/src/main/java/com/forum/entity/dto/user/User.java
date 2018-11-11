package com.forum.entity.dto.user;

import com.forum.entity.dto.BaseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User extends BaseEntity implements Serializable{


    private static final long serialVersionUID = 5346834195630711994L;
    @Column
    private String userName;

    @Column
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

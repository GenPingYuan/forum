package com.forum.iweb.controller;


import com.forum.entity.dto.User;
import com.forum.jdbc.Repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys")
public class SysController {

    private static Logger logger = LoggerFactory.getLogger(SysController.class);

    @Autowired
    private UsersRepository userRepository;

    @ResponseBody
    @GetMapping("/index")
    public String index(){
        logger.info("打印的日志");
        User user = new User();
        user.setUserName("maomao");
        user.setPassword("11111");
        userRepository.save(user);
        return "Hello World";
    }
}

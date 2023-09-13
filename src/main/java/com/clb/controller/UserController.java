package com.clb.controller;

import com.clb.domain.query.PageQuery;
import com.clb.domain.vo.PageVO;
import com.clb.domain.vo.UserVO;
import com.clb.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor    //可以给被final或者@NonNull注解标记的字段生成构造器,配合final可以实现自动装配
public class UserController {

    private final IUserService userService;

    @GetMapping("/page")
    public PageVO<UserVO> queryUserByPage(PageQuery pageQuery) {
        return userService.queryUserByPage(pageQuery);
    }
}

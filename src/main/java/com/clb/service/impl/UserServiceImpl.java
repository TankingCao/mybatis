package com.clb.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clb.domain.pojo.User;
import com.clb.domain.query.PageQuery;
import com.clb.domain.vo.PageVO;
import com.clb.domain.vo.UserVO;
import com.clb.mapper.UserMapper;
import com.clb.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public PageVO<UserVO> queryUserByPage(PageQuery pageQuery) {
        //1.分页条件
        Page<User> p = pageQuery.toMpPageSortByUpdateTime();

        //2.查询
        page(p);

        //3.返回
        return new PageVO<>(p, user -> {
            UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
            //给用户名称最后两位加上**
            String username = user.getUsername();
            userVO.setUsername(username.substring(0, username.length() - 2) + "**");

            return userVO;
        });
    }
}

package com.clb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clb.domain.pojo.User;
import com.clb.domain.query.PageQuery;
import com.clb.domain.vo.PageVO;
import com.clb.domain.vo.UserVO;

public interface IUserService extends IService<User> {
    PageVO<UserVO> queryUserByPage(PageQuery pageQuery);
}

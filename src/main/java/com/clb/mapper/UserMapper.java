package com.clb.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clb.domain.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    //根据id数组查询用户数据
    List<User> queryUserByIds(@Param("ids") List<Long> ids);

    //根据id更新数据
    @Update("update tb_user set balance = balance - #{amount} ${ew.customSqlSegment}")
    void updateBalanceByWrapper(@Param("amount") int amount, @Param("ew") LambdaQueryWrapper<User> wrapper);

    //多表查询
    List<User> queryUserByWrapper(@Param("ew") QueryWrapper<User> wrapper);
}

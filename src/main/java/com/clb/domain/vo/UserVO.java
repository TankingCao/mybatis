package com.clb.domain.vo;

import com.clb.domain.pojo.UserInfo;
import com.clb.enums.UserStatus;
import lombok.Data;

@Data
public class UserVO {
    private Long id;
    private String username;
    private UserInfo info;
    private UserStatus status;
    private Long balance;


}

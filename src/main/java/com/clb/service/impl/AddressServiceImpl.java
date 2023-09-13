package com.clb.service.impl;

import com.clb.domain.pojo.Address;
import com.clb.mapper.AddressMapper;
import com.clb.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clibin
 * @since 2023-09-13
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}

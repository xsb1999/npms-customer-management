package com.neu.customermanagement.management.service.impl;

import com.neu.customermanagement.management.entity.Customer;
import com.neu.customermanagement.management.mapper.CustomerMapper;
import com.neu.customermanagement.management.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xsb
 * @since 2021-07-07
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}

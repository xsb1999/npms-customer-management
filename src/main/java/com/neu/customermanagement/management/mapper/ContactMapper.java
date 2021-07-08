package com.neu.customermanagement.management.mapper;

import com.neu.customermanagement.management.entity.Contact;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xsb
 * @since 2021-07-07
 */
@Mapper
@Repository
public interface ContactMapper extends BaseMapper<Contact> {

}

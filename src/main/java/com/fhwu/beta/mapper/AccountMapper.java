package com.fhwu.beta.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fhwu.beta.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : dell
 * @InterfaceName : com.fhwu.beta.mapper.AccountMapper
 * @Description :
 * @date : 2024/08/18 018 16:19
 */

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}

package com.fhwu.beta.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fhwu.beta.entity.Account;
import com.fhwu.beta.mapper.AccountMapper;
import com.fhwu.beta.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author : dell
 * @ClassName : com.fhwu.beta.service.impl.AccountServiceImpl
 * @Description :
 * @date : 2024/08/18 018 16:21
 */

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
        implements AccountService {
}

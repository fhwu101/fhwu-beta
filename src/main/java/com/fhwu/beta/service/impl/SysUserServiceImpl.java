package com.fhwu.beta.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fhwu.beta.entity.SysUser;
import com.fhwu.beta.mapper.SysUserMapper;
import com.fhwu.beta.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @author : fhwu
 * @ClassName : com.fhwu.beta.service.impl.SysUserServiceImpl
 * @Description :
 * @date : 2024/08/18 018 17:19
 */


@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}

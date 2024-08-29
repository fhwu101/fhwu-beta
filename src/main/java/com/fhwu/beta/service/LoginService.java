package com.fhwu.beta.service;

import cn.dev33.satoken.util.SaResult;
import com.fhwu.beta.entity.SysUser;
import com.fhwu.beta.entity.vo.Result;

/**
 * @author : fhwu
 * @InterfaceName : com.fhwu.beta.service.LoginService
 * @Description :
 * @date : 2024/08/18 018 18:00
 */
public interface LoginService {

    Result<String> login(SysUser user);

    Result<String> logout();

    Result<String> register(SysUser user);
}

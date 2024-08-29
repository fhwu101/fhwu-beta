package com.fhwu.beta.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fhwu.beta.entity.SysUser;
import com.fhwu.beta.entity.vo.Result;
import com.fhwu.beta.service.LoginService;
import com.fhwu.beta.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author : fhwu
 * @ClassName : com.fhwu.beta.service.impl.LoginServiceImpl
 * @Description :
 * @date : 2024/08/18 018 18:01
 */


@Service
public class LoginServiceImpl implements LoginService {

    @Resource(name = "sysUserServiceImpl")
    private SysUserService userService;

    @Override
    public Result<String> login(SysUser user) {
        if (Optional.of(user).isEmpty()){
            return Result.error("登录失败");
        }
        String token = null;
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_code", user.getUserCode());
        queryWrapper.eq("password", DigestUtil.md5Hex(user.getPassword()));
        Optional<SysUser> oneOpt = userService.getOneOpt(queryWrapper);
        if (oneOpt.isPresent()) {
            //sa-token 生成token
            StpUtil.login(oneOpt.get().getId());
            // 在登录时缓存 user 对象
            StpUtil.getSession().set("user", oneOpt.get());
            return Result.success("登录成功", StpUtil.getTokenValue());
        }

        return Result.error("登录失败");
    }

    @Override
    public Result<String> logout() {
        StpUtil.logout();
        return Result.success("退出成功");
    }

    @Override
    public Result<String> register(SysUser user) {
        //账号是否已注册
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_code", user.getUserCode());
        Optional<SysUser> oneOpt = userService.getOneOpt(queryWrapper);
        if (oneOpt.isPresent()) {
            return Result.error("1001","注册失败","该账号已注册");
        }
        user.setPassword(DigestUtil.md5Hex(user.getPassword()));
        user.setCreateBy(LocalDateTime.now());
        boolean register = userService.save(user);
        return register ? Result.success("注册成功") : Result.error("注册失败");
    }

}

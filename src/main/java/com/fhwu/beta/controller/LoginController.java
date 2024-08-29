package com.fhwu.beta.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.util.SaResult;
import com.fhwu.beta.entity.SysUser;
import com.fhwu.beta.entity.vo.Result;
import com.fhwu.beta.service.LoginService;
import com.fhwu.beta.service.SysUserService;
import jakarta.annotation.Resource;
import jakarta.annotation.Resources;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

/**
 * @author : fhwu
 * @ClassName : com.fhwu.beta.controller.LoginController
 * @Description :
 * @date : 2024/08/18 018 17:56
 */


@RestController
@RequestMapping("/" )
@CrossOrigin(origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST}
)
public class LoginController {

    @Resource(name = "loginServiceImpl")
    private LoginService loginService;

    @SaIgnore
    @PostMapping("login")
    public Result<String> login(@RequestBody SysUser user) {

        return loginService.login(user);
    }

    @GetMapping("logout")
    public Result<String> logout() {

        return loginService.logout();
    }

    @SaIgnore
    @GetMapping("register")
    public Result<String> register(@RequestBody SysUser user) {

        return loginService.register(user);
    }

}

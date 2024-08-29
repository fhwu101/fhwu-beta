package com.fhwu.beta.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.hutool.crypto.digest.DigestUtil;
import com.fhwu.beta.entity.SysUser;
import com.fhwu.beta.entity.vo.Result;
import com.fhwu.beta.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : dell
 * @ClassName : com.fhwu.beta.controller.SysUserController
 * @Description :
 * @date : 2024/08/18 018 17:21
 */

@RestController
@RequestMapping("/user")
@SaCheckLogin
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SysUserController {


    @Resource(name = "sysUserServiceImpl")
    private SysUserService userService;

    @GetMapping
    public Result<List<SysUser>> list() {
//        List<SysUser> list = userService.list();
        List<SysUser> list = userService.list().stream()
                .map(user -> {
                    user.setPassword(null);
                    return user;
                }).collect(Collectors.toList());
        return Result.success(list);
    }

    @PostMapping
    public Result<SysUser> save(@RequestBody SysUser user) {
        if( Optional.of(user).isEmpty() ) {
            return Result.error("用户信息为空");
        }
        user.setPassword(DigestUtil.md5Hex(user.getPassword()));
        user.setCreateBy(LocalDateTime.now());
        boolean save = userService.save(user);
        return save ? Result.success(user) : Result.error("保存失败");
    }


    @PutMapping
    public Result<SysUser> update(@RequestBody SysUser user) {
        if( Optional.of(user).isEmpty() ) {
            return Result.error("用户信息为空");
        }
        if( ! Optional.of(user.getPassword()).isEmpty() ) {
            user.setPassword(DigestUtil.md5Hex(user.getPassword()));
        }
        user.setModifyBy(LocalDateTime.now());
        boolean update = userService.updateById(user);
        return update ? Result.success(user) : Result.error("修改失败");
    }


    @DeleteMapping("/{id}")
    public Result<SysUser> delete(@PathVariable Long id) {

//        userService.getOptById(id).ifPresent(user -> {
//            user.setIsDelete(1);
//            user.setModifyBy(LocalDateTime.now());
//            userService.updateById(user);
//        });
        SysUser user = userService.getById(id);
        user.setIsDeleted(1);
        user.setModifyBy(LocalDateTime.now());
        boolean delete = userService.updateById(user);
        return delete ? Result.success(user) : Result.error("删除失败");
    }

    @GetMapping("/{id}")
    public Result<SysUser> get(@PathVariable Long id) {
        SysUser user = userService.getById(id);
        user.setPassword(null);
        return Result.success(user);
    }

}

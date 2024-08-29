package com.fhwu.beta.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fhwu.beta.entity.Account;
import com.fhwu.beta.entity.SysUser;
import com.fhwu.beta.entity.vo.Result;
import com.fhwu.beta.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : dell
 * @ClassName : com.fhwu.beta.controller.AccountController
 * @Description :
 * @date : 2024/08/18 018 16:24
 */

@RestController
@RequestMapping("/account")
@SaCheckLogin
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class AccountController {

    @Resource(name = "accountServiceImpl")
    private AccountService accountService;

    @GetMapping
    public Result<List<Account>> list(){
        SysUser user = (SysUser) StpUtil.getSession().get("user");
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_delete", 0);
        queryWrapper.eq("user_code", user.getUserCode());
        List<Account> list = accountService.list(queryWrapper);


        return Result.success(list);
    }

    @PostMapping
    public Result<Account> save(@RequestBody Account account){
        account.setCreateTime(LocalDateTime.now());
        boolean save = accountService.save(account);
        return save ? Result.success(account) : Result.error("新增失败");
    }

    @PutMapping
    public Result<Account> update(@RequestBody Account account){
        account.setModifyTime(LocalDateTime.now());
        boolean update = accountService.updateById(account);
        return update ? Result.success(account) : Result.error("修改失败");
    }

    @DeleteMapping("/{id}")
    public Result<Account> delete(@PathVariable Long id) {
        Account account = new Account();
        account.setId(id);
        account.setIsDelete(1);
        account.setModifyTime(LocalDateTime.now());
        boolean remove = accountService.updateById(account); // 逻辑删除
        return remove ? Result.success(account) : Result.error("删除失败");
    }

    @GetMapping("/{id}")
    public Result<Account> findById(@PathVariable String id) {
        Account account = accountService.getById(id);
        return Result.success(account);
    }

}

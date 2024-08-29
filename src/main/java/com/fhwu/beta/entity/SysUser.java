package com.fhwu.beta.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * @author : fhwu
 * @ClassName : com.fhwu.beta.entity.SysUser
 * @Description :
 * @date : 2024/08/18 018 17:14
 */

@Data
@ToString
@TableName("t_user")
public class SysUser {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    private String userCode;
    private String password;
    private LocalDateTime createBy;
    private LocalDateTime modifyBy;
    private Integer isDisabled;
    private Integer isDeleted;
}

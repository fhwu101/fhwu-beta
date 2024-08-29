package com.fhwu.beta.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author : fhwu
 * @ClassName : com.fhwu.bookkeeping.entity.Account
 * @Description : 账目实体类
 * @date : 2024/08/16 016 22:08
 */


@Data
@TableName("t_account")
@ToString
public class Account {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String itemName;
    private Integer itemType;
    private BigDecimal amount;
    private String remark;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private Integer isDelete;
    private String userCode;


}

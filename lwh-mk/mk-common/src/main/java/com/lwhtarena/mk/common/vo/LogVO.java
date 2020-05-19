package com.lwhtarena.mk.common.vo;

import com.lwhtarena.mk.common.entity.SysLog;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liwh
 * @Title: LogVO
 * @Package com.lwhtarena.mk.common.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 17:59
 */
@Data
public class LogVO implements Serializable {
    private SysLog sysLog;
    private String username;
}

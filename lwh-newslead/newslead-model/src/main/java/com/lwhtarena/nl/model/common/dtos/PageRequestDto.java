package com.lwhtarena.nl.model.common.dtos;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liwh
 * @Title: PageRequestDto
 * @Package com.lwhtarena.nl.model.common.dtos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:00
 */
@Data
@Slf4j
public class PageRequestDto {
    protected Integer size;
    protected Integer page;

    public void checkParam() {
        if (this.page == null || this.page < 0) {
            setPage(1);
        }
        if (this.size == null || this.size < 0 || this.size > 100) {
            setSize(10);
        }
    }
}

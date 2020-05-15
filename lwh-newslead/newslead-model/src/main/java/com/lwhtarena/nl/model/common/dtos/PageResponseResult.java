package com.lwhtarena.nl.model.common.dtos;

/**
 * @author liwh
 * @Title: PageResponseResult
 * @Package com.lwhtarena.nl.model.common.dtos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:02
 */
public class PageResponseResult extends ResponseResult {
    private Integer currentPage;
    private Integer size;
    private Integer total;

    public PageResponseResult(Integer currentPage, Integer size, Integer total) {
        this.currentPage = currentPage;
        this.size = size;
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

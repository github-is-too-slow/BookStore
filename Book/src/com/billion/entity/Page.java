package com.billion.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Billion
 * @create 2021/02/07 14:41
 */
public class  Page<T> implements Serializable{
    public static final Integer PAGESIZE = 4;

    private Integer pageNo;
    private Integer pageTotal;//总页数
    private Integer pageTotalCount;//总记录数
    private Integer pageSize = PAGESIZE;
    private List<T> items;
    private String url;//分页条中的请求地址

    public Page() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if(pageNo < 1){
            pageNo = 1;
        }
        if(pageNo > pageTotal){
            pageNo = pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageTotalCount=" + pageTotalCount +
                ", pageSize=" + pageSize +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}

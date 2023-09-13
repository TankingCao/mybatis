package com.clb.domain.query;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class PageQuery {
    private Integer pageNo = 1;
    private Integer pageSize = 5;
    private Boolean isAsc = false;
    private String sortBy;

    //把当前的query构造成mybatis-plus的Page
    public <T> Page<T> toMpPage(String defaultSortBy, Boolean isAsc) {
        //1.分页条件
        Page<T> p = Page.of(pageNo, pageSize);

        //2.查询条件
        if (StrUtil.isNotBlank(sortBy)) {
            p.addOrder(new OrderItem(sortBy, isAsc));
        } else {
            p.addOrder(new OrderItem(defaultSortBy, isAsc));
        }
        return p;
    }

    //把当前的query构造成mybatis-plus的Page
    public <T> Page<T> toMpPage(OrderItem... defaultOrderItems) {
        //1.分页条件
        Page<T> p = Page.of(pageNo, pageSize);

        //2.查询条件
        if (StrUtil.isNotBlank(sortBy)) {
            p.addOrder(new OrderItem(sortBy, isAsc));
            return p;
        }

        for (OrderItem it : defaultOrderItems) {
            p.addOrder(it);
        }

        return p;
    }

    //把当前的query构造成mybatis-plus的Page
    public <T> Page<T> toMpPageSortByUpdateTime() {
        //1.分页条件
        Page<T> p = Page.of(pageNo, pageSize);

        p.addOrder(new OrderItem("update_time", false));
        return p;
    }
}

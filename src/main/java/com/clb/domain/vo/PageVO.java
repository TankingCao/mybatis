package com.clb.domain.vo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class PageVO<T> {
    private Long total;
    private Long pages;
    private List<T> list;


    public <P> PageVO(Page<P> p, Class<T> clazz) {
        this.total = p.getTotal();
        this.pages = p.getPages();
        List<P> records = p.getRecords();
        if (CollUtil.isEmpty(records)) {
            //没有数据，直接返回空数组
            this.list = Collections.emptyList();
            return;
        }

        this.list = BeanUtil.copyToList(records, clazz);
    }

    public <P> PageVO(Page<P> p, Function<P, T> convertor) {
        this.total = p.getTotal();
        this.pages = p.getPages();
        List<P> records = p.getRecords();
        if (CollUtil.isEmpty(records)) {
            //没有数据，直接返回空数组
            this.list = Collections.emptyList();
            return;
        }

        this.list = records.stream().map(convertor).collect(Collectors.toList());
    }
}

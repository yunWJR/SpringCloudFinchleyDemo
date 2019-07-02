package com.yun.base.module;

import com.querydsl.core.QueryResults;
import lombok.Data;

import java.util.List;

/**
 * @author: yun
 * @createdOn: 2019-02-28 18:54.
 */

@Data
public class PageBean<T> {
    private final long pageIndex;
    private final long pageSize;
    private final long totalCount;
    private final long totalPage;
    private final List<T> results;

    public PageBean(QueryResults<T> rst) {
        pageIndex = rst.getOffset() / rst.getLimit();

        // todo 暂时处理
        pageSize = rst.getLimit() == Long.MAX_VALUE ? 20 : rst.getLimit();

        totalCount = rst.getTotal();

        results = rst.getResults();

        if (pageSize > 0) {
            long page = totalCount / pageSize;
            if (totalCount % pageSize > 0) {
                page++;
            }

            totalPage = page;
        } else {
            totalPage = 0;
        }
    }
}

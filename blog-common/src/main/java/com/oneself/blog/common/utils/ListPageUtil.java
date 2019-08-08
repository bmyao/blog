package com.oneself.blog.common.utils;


import java.util.List;

/**
 * @Describe list分页工具
 * @Author: liangjiayao
 * @Date: 2019/6/12 15:53
 * @Version 1.0
 */
public class ListPageUtil {

    private ListPageUtil(){

    }

    /**
     * 分页
     * @param list 分页的集合
     * @param currentPage 当前页
     * @param pageSize 页码
     * @return
     */
    public static List page(List list, int currentPage, int pageSize) {
        int totalCount = list.size();
        if(pageSize > totalCount){
            return list;
        }
        //总页数
        int pageCount = 0;
        List subList;
        int m = totalCount % pageSize;
        if (m > 0) {
            pageCount = totalCount / pageSize + 1;
        } else {
            pageCount = totalCount / pageSize;
        }
        //分页
        if (m == 0) {
            subList = list.subList((currentPage - 1) * pageSize, pageSize * (currentPage));
        } else {
            //判断是否最后一页
            if (currentPage == pageCount) {
                subList = list.subList((currentPage - 1) * pageSize, totalCount);
            } else {
                subList = list.subList((currentPage - 1) * pageSize, pageSize * (currentPage));
            }
        }
        return subList;
    }

}


package com.wz.service;

import com.wz.common.ServerResponse;
import com.wz.pojo.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface ICategoryService {

    /**
     *
     * 添加类别
     * */
    public ServerResponse addCategory(Category Category);

    /**
     *
     * 修改类别
     * categoryId
     * category
     * cat
     * */
    public ServerResponse updateCategory(Category Category);

    /**
     *
     * 查看平级类别
     * categoryId
     * */
    public ServerResponse getCategoryById(Integer categoryId);

    /**
     *
     * 查看平级类别
     * categoryId
     * */
    public ServerResponse deepCategory(Integer categoryId);


    /**
     * 根据ID查询类别
     * */
    public ServerResponse<Category> selectCategory(Integer categoryId);

}

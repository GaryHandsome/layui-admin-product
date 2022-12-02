package org.pms.dao;

import org.pms.entity.Product;

import java.util.List;

/**
 * 商品DAO接口
 *
 * @author zqx
 * @date 2022-12-02
 */
public interface ProductDao {
    /**
     * 查询所有的商品
     *
     * @return
     */
    List<Product> selectAll();
}

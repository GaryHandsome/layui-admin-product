package org.pms.dao;

import org.pms.entity.ProductType;

import java.util.List;

/**
 * 商品类型DAO接口
 *
 * @author zqx
 * @date 2022-12-02
 */
public interface ProductTypeDao {

    /**
     * 查询所有的商品类型
     *
     * @return
     */
    List<ProductType> selectAll();
}

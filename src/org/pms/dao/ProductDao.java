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
     * 增
     *
     * @param p
     * @return
     */
    int insert(Product p);

    /**
     * 删
     *
     * @param pid
     * @return
     */
    int delete(String pid);

    /**
     * 改
     *
     * @param p
     * @return
     */
    int update(Product p);

    /**
     * 查询所有的商品
     *
     * @return
     */
    List<Product> selectAll();

    /**
     * 动态条件 + 分页查询
     *
     * @param product 查询条件（商品名称、商品类型）
     * @param page 当前页
     * @param limit 每页显示记录数
     * @return
     */
    List<Product> selectByPage(Product product, Integer page, Integer limit);

    /**
     * 动态条件 + 分页查询 - 总记录数
     *
     * @param product
     * @return
     */
    Long selectByPageCount(Product product);
}

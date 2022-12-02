package org.pms.test;

import org.pms.dao.ProductDao;
import org.pms.dao.impl.ProductDaoImpl;
import org.pms.entity.Product;

import java.util.List;

/**
 * 页面（UI,用户操作界面）
 *
 * Servlet（控制中心，获取页面发起的请求 - 加工处理 - 响应处理的结果）
 *  同步 - 作用域 + JSP + JSTL + EL
 *  异步（使用JQuery中的Ajax请求） - GSON + JSON + PrintWriter
 *
 * @author zqx
 * @date 2022-12-02
 */
public class ProductDaoTest {
    public static void main(String[] args) {
        // 实例化商品接口对象
        ProductDao productDao = new ProductDaoImpl();

        List<Product> list = productDao.selectAll();

        for (Product p : list) {
            System.out.println(p.getProductName());
        }
    }
}

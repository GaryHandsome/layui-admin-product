package org.pms.test;

import org.pms.dao.ProductDao;
import org.pms.dao.impl.ProductDaoImpl;
import org.pms.entity.Product;

import java.util.Date;
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

        Product product = new Product();
        // product.setProductName("7");
        // product.setProductType("玩具");

        List<Product> list = productDao.selectByPage(product,1,5) ;
        Long count = productDao.selectByPageCount(product);

        System.out.println("数量："+count);
        for (Product p : list) {
            System.out.println(p.getProductName());
        }
    }

    private static void deleteTest() {
        // 实例化商品接口对象
        ProductDao productDao = new ProductDaoImpl();
        int r = productDao.delete("250") ;
        System.out.println(r);
    }

    private static void updateTest() {
        // 实例化商品接口对象
        ProductDao productDao = new ProductDaoImpl();

        Product p = new Product();
        p.setProductId("250");
        p.setProductName("电脑");
        p.setProductCount(1000);
        p.setProductImage("computer.jpg");
        p.setProductPrice(1000);
        p.setProductStatus(0);
        p.setProductDesc("性能超好的电脑");
        p.setProductSale(100);
        p.setProductType("家电");
        p.setProductDate(new Date());

        int r = productDao.update(p) ;

        System.out.println(r);
    }

    private static void insertTest() {
        // 实例化商品接口对象
        ProductDao productDao = new ProductDaoImpl();

        Product p = new Product();
        p.setProductId("250");
        p.setProductName("手机");
        p.setProductCount(100);
        p.setProductImage("phone.jpg");
        p.setProductPrice(250);
        p.setProductStatus(1);
        p.setProductDesc("好手机");
        p.setProductSale(10);
        p.setProductType("家电");
        p.setProductDate(new Date());

        int r = productDao.insert(p) ;

        System.out.println(r);
    }


    /**
     * 测试查询所有数据
     */
    private static void queryAll() {
        // 实例化商品接口对象
        ProductDao productDao = new ProductDaoImpl();

        List<Product> list = productDao.selectAll();

        for (Product p : list) {
            System.out.println(p.getProductName());
        }
    }
}

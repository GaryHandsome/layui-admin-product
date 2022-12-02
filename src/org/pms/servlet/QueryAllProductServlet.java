package org.pms.servlet;

import org.pms.dao.ProductDao;
import org.pms.dao.impl.ProductDaoImpl;
import org.pms.entity.Product;
import org.pms.vo.ResponseData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查询所有商品
 *
 * @author zqx
 * @date 2022-12-02
 */
@WebServlet("/admin/queryAll.do")
public class QueryAllProductServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 实例化商品接口对象
        ProductDao productDao = new ProductDaoImpl();
        List<Product> list = productDao.selectAll();

        // 封装响应的数据
        ResponseData responseData = successJson(list);

        // 打印输出到客户端浏览器
        print(resp,responseData);
    }
}

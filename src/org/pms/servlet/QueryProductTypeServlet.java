package org.pms.servlet;

import org.pms.dao.ProductDao;
import org.pms.dao.ProductTypeDao;
import org.pms.dao.impl.ProductDaoImpl;
import org.pms.dao.impl.ProductTypeDaoImpl;
import org.pms.entity.Product;
import org.pms.entity.ProductType;
import org.pms.vo.ResponseData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查询商品类型，回显在页面中的查询条件
 *
 * @author zqx
 * @date 2022-12-02
 */
@WebServlet("/admin/QueryProductTypeServlet")
public class QueryProductTypeServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 实例化商品接口对象
        ProductTypeDao productDao = new ProductTypeDaoImpl();
        List<ProductType> list = productDao.selectAll();

        // 封装响应的数据
        ResponseData responseData = successJson(list);

        // 打印输出到客户端浏览器
        print(resp,responseData);
    }
}

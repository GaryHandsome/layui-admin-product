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
@WebServlet("/admin/queryByPager.do")
public class QueryByPagerProductServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取客户端浏览器请示过来的参数
        String productName = req.getParameter("name");
        String productType = req.getParameter("type");
        Product product = new Product();
        product.setProductName(productName);
        product.setProductType(productType);

        // 当前页
        int page = Integer.parseInt(req.getParameter("page"));

        // 每页记录数
        int limit = Integer.parseInt(req.getParameter("limit"));

        // 实例化商品接口对象
        ProductDao productDao = new ProductDaoImpl();
        List<Product> list = productDao.selectByPage(product,page,limit) ;
        Long count = productDao.selectByPageCount(product);

        // 封装响应的数据 - 注意：分页查询，除了需要数据以外，还需要总记录数
        ResponseData responseData = pageVo(count,list);

        // 打印输出到客户端浏览器
        print(resp,responseData);
    }
}

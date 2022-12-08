package org.pms.servlet;

import org.pms.dao.impl.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除商品
 *
 * @Date 2022-12-06
 * @Author zqx
 */
@WebServlet("/admin/RemoveProductServlet")
public class RemoveProductServlet extends BaseServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("pid");
        ProductDaoImpl productDao = new ProductDaoImpl();
        int row = productDao.delete(productId);

        if(row==1) {
            print(resp,successJson(200,"删除成功",""));
            return ;
        }
        print(resp,errorJson(500,"删除失败",""));
    }
}

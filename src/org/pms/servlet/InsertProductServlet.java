package org.pms.servlet;

import org.pms.dao.impl.ProductDaoImpl;
import org.pms.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 添加商品
 *
 * @Date 2022-12-06
 * @Author zqx
 */
@WebServlet("/admin/InsertProductServlet")
public class InsertProductServlet extends BaseServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 第一：获取表单中输入的数据
        // 第二：合法性验证（略）
        String productId = req.getParameter("productId");
        String productName = req.getParameter("productName");
        String productType = req.getParameter("productType");
        double productPrice = Double.parseDouble(req.getParameter("productPrice"));
        int productStatus = Integer.parseInt(req.getParameter("productStatus"));
        String productDesc = req.getParameter("productDesc");

        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setProductType(productType);
        product.setProductPrice(productPrice);
        product.setProductStatus(productStatus);
        product.setProductDesc(productDesc);
        // 注意：这里一般需要用户上传图片（略）
        product.setProductImage("default.jpg");
        product.setProductDate(new Date());

        // 第三：实例化DAO对象
        int row = new ProductDaoImpl().insert(product);

        // 第四：响应
        if(row==1) {
            print(resp,successJson(200,"添加成功",""));
            return ;
        }
        print(resp,errorJson(500,"添加失败",""));
    }
}

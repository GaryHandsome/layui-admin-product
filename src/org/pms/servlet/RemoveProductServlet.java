package org.pms.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除商品
 *
 * @Date 2022-12-06
 * @Author zqx
 */
public class RemoveProductServlet extends BaseServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 删除商品....
        System.out.println("根据商品名称删除");
        System.out.println("删除成功");
    }
}

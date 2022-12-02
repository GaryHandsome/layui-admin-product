package org.pms.servlet;

import com.google.gson.GsonBuilder;
import org.pms.vo.ErrorTips;
import org.pms.vo.PageVo;
import org.pms.vo.ResponseData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 它是所有的用户定义Servlet的父类 - 把一些公共操作的代码，抽象提取出来，在父类中定义，子类可以直接使用
 *
 * @author zqx
 * @date 2022-12-02
 */
public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * 封装错误提示
     *
     * @param msg
     * @param url
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void error(String msg, String url, HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        this.error(msg, url, "返回", req, resp);
    }

    /**
     * 封装错误提示
     *
     * @param msg
     * @param url
     * @param tips
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void error(String msg, String url, String tips, HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        ErrorTips error = new ErrorTips(msg, url, tips);
        req.setAttribute("error", error);
        req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
    }


    /**
     * 成功响应的封装 - 默认
     *
     * @return
     */
    public ResponseData successJson(Object data) {
        return new ResponseData(200, "", data);
    }

    /**
     * 重载方法 - 封装所有的成功响应信息
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public ResponseData successJson(Integer code, String msg, Object data) {
        return new ResponseData(code, msg, data);
    }

    /**
     * 错误响应的封装 - 默认
     *
     * @param msg
     * @return
     */
    public ResponseData errorJson(String msg) {
        return new ResponseData(500, msg, null);
    }

    /**
     * 重载方法 - 封装所有的错误响应信息
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public ResponseData errorJson(Integer code, String msg, Object data) {
        return new ResponseData(code, msg, data);
    }


    /**
     * 响应 JSON 字符串到客户端浏览器中
     *
     * @param resp
     * @param responseData
     * @throws IOException
     */
    protected void print(HttpServletResponse resp, ResponseData responseData)
            throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss.SSS")
                .create()
                .toJson(responseData));
        out.flush();
        out.close();
    }

    /**
     * 封装PageVo
     *
     * @param count
     * @param data
     * @return
     */
    protected PageVo pageVo(Long count, Object data) {
        PageVo vo = new PageVo();
        vo.setCode(0);
        vo.setCount(count);
        vo.setData(data);
        return vo;
    }
}

package org.pms.vo;

/**
 * 封装服务器响应的数据 - 统一 API 接口
 *
 * @author zqx
 * @date 2022-12-02
 */
public class ResponseData {
    /**
     * 响应代码（如：200、500、或其它根据业务自定义代码）
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String msg;
    /**
     * 响应的数据
     */
    private Object data;

    public ResponseData() {
    }

    public ResponseData(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

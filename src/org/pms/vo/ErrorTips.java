package org.pms.vo;

/**
 * 错误提示
 *
 * @author zqx
 * @date 2022-12-02
 */
public class ErrorTips {
    /**
     * 错误的消息
     */
    private String msg;

    /**
     * 错误返回地址
     */
    private String url;

    /**
     * 文本提示
     */
    private String tips;

    public ErrorTips() {
    }

    public ErrorTips(String msg, String url, String tips) {
        this.msg = msg;
        this.url = url;
        this.tips = tips;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}

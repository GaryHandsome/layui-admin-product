package org.pms.vo;

/**
 * @author zqx
 * @date 2022-12-02
 */
public class PageVo extends ResponseData{
    /**
     * 总记录数
     */
    private Long count;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

package org.pms.entity;

/**
 * 商品类型
 *
 * @Date 2022-12-07
 * @Author zqx
 */
public class ProductType {
    /**
     * 类型编号
     */
    private int typeId ;
    /**
     * 类型名称
     */
    private String typeName ;
    /**
     * 上一级类型编号
     */
    private int parentId ;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}

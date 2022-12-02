package org.pms.entity;

import java.util.Date;

/**
 * 商品实体对象
 *
 * @author zqx
 * @date 2022-12-02
 */
public class Product {
    /**
     * 商品编号
     */
    private String productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品类型
     */
    private String productType;
    /**
     * 商品价格
     */
    private double productPrice;
    /**
     * 商品库存数量
     */
    private int productCount;
    /**
     * 商品图片
     */
    private String productImage;
    /**
     * 上架日期
     */
    private Date productDate;
    /**
     * 商品描述
     */
    private String productDesc;
    /**
     * 商品销售量
     */
    private int productSale;
    /**
     * 商品状态 - 上架（1）、下架（0）
     */
    private int productStatus ;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductSale() {
        return productSale;
    }

    public void setProductSale(int productSale) {
        this.productSale = productSale;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }
}

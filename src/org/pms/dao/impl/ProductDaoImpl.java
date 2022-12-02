package org.pms.dao.impl;

import org.pms.dao.ProductDao;
import org.pms.entity.Product;
import org.pms.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品DAO接口的实现
 *
 * @author zqx
 * @date 2022-12-02
 */
public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> selectAll() {
        List<Product> list = new ArrayList<>();
        // 第一：定义要操作数据库的SQL语句
        String sql = "select product_id,product_name,product_price,product_count,product_image,product_date,product_desc,product_sale,product_status from product";

        // 第二：获取连接对象
        Connection conn = DbUtil.getConnection();
        PreparedStatement pstmt = null ;
        ResultSet rst = null ;

        try {
            // 第三：预编译SQL语句
            pstmt = conn.prepareStatement(sql);

            // 第四：填充占位符中的数据

            // 第五：执行SQL语句
            rst = pstmt.executeQuery();

            // 第六：对执行的结果进行处理
            while(rst.next()) {
                // 1.读取当前行中各列的数据
                String productId = rst.getString(1);
                String productName = rst.getString(2);
                double productPrice = rst.getDouble(3);
                int productCount = rst.getInt(4);
                String productImage = rst.getString(5);
                Timestamp productDate = rst.getTimestamp(6);
                String productDesc = rst.getString(7);
                int productSale = rst.getInt(8);
                int productStatus = rst.getInt(9);

                // 2.实例化实体对象
                Product p = new Product();

                // 3.封装数据，把读取到的各列数据，封装到实体对象中
                p.setProductId(productId);
                p.setProductName(productName);
                p.setProductPrice(productPrice);
                p.setProductCount(productCount);
                p.setProductImage(productImage);
                p.setProductDate(productDate);
                p.setProductDesc(productDesc);
                p.setProductSale(productSale);
                p.setProductStatus(productStatus);

                // 4.把实体对象添加到 List 集合中
                list.add(p) ;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 第七：关闭相关的对象
            DbUtil.close(conn,pstmt,rst);
        }
        return list;
    }
}

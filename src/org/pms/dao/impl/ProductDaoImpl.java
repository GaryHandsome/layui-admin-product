package org.pms.dao.impl;

import org.pms.dao.ProductDao;
import org.pms.entity.Product;
import org.pms.util.DbUtil4MsSql;

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
    public int insert(Product p) {
        int r = 0;
        // 第一：定义要操作数据库的SQL语句
        String sql = "insert into product(product_id,product_name,product_type,product_price,product_count,product_image,product_date,product_desc,product_sale,product_status) values (?,?,?,?,?,?,?,?,?,?)";

        // 第二：获取连接对象
        Connection conn = DbUtil4MsSql.getConnection();
        PreparedStatement pstmt = null;

        try {
            // 第三：预编译SQL语句
            pstmt = conn.prepareStatement(sql);

            // 第四：填充占位符中的数据
            pstmt.setString(1, p.getProductId());
            pstmt.setString(2, p.getProductName());
            pstmt.setString(3, p.getProductType());
            pstmt.setDouble(4, p.getProductPrice());
            pstmt.setInt(5, p.getProductCount());
            pstmt.setString(6, p.getProductImage());
            pstmt.setTimestamp(7, new Timestamp(p.getProductDate().getTime()));
            pstmt.setString(8, p.getProductDesc());
            pstmt.setInt(9, p.getProductSale());
            pstmt.setInt(10, p.getProductStatus());

            // 第五：执行SQL语句
            r = pstmt.executeUpdate();

            // 第六：对执行的结果进行处理
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 第七：关闭相关的对象
            DbUtil4MsSql.close(conn, pstmt, null);
        }
        return r;
    }

    @Override
    public int delete(String pid) {
        int r = 0;
        // 第一：定义要操作数据库的SQL语句
        String sql = "delete from product where product_id=?";

        // 第二：获取连接对象
        Connection conn = DbUtil4MsSql.getConnection();
        PreparedStatement pstmt = null;

        try {
            // 第三：预编译SQL语句
            pstmt = conn.prepareStatement(sql);

            // 第四：填充占位符中的数据
            pstmt.setString(1, pid);

            // 第五：执行SQL语句
            r = pstmt.executeUpdate();

            // 第六：对执行的结果进行处理
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 第七：关闭相关的对象
            DbUtil4MsSql.close(conn, pstmt, null);
        }
        return r;
    }

    @Override
    public int update(Product p) {
        int r = 0;
        // 第一：定义要操作数据库的SQL语句
        String sql = "update product set product_name=?,product_type=?,product_price=?,product_status=?,product_desc=? where product_id=?";

        // 第二：获取连接对象
        Connection conn = DbUtil4MsSql.getConnection();
        PreparedStatement pstmt = null;

        try {
            // 第三：预编译SQL语句
            pstmt = conn.prepareStatement(sql);

            // 第四：填充占位符中的数据
            pstmt.setString(1, p.getProductName());
            pstmt.setString(2, p.getProductType());
            pstmt.setDouble(3, p.getProductPrice());
            pstmt.setInt(4, p.getProductStatus());
            pstmt.setString(5, p.getProductDesc());
            pstmt.setString(6, p.getProductId());

            // 第五：执行SQL语句
            r = pstmt.executeUpdate();

            // 第六：对执行的结果进行处理
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 第七：关闭相关的对象
            DbUtil4MsSql.close(conn, pstmt, null);
        }
        return r;
    }

    @Override
    public List<Product> selectAll() {
        List<Product> list = new ArrayList<>();
        // 第一：定义要操作数据库的SQL语句
        String sql = "select product_id,product_name,product_price,product_count,product_image,product_date,product_desc,product_sale,product_status from product";

        // 第二：获取连接对象
        Connection conn = DbUtil4MsSql.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rst = null;

        try {
            // 第三：预编译SQL语句
            pstmt = conn.prepareStatement(sql);

            // 第四：填充占位符中的数据

            // 第五：执行SQL语句
            rst = pstmt.executeQuery();

            // 第六：对执行的结果进行处理
            while (rst.next()) {
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
                list.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 第七：关闭相关的对象
            DbUtil4MsSql.close(conn, pstmt, rst);
        }
        return list;
    }

    @Override
    public List<Product> selectByPage(Product product, Integer page, Integer limit) {
        List<Product> list = new ArrayList<>();

        // 第一：定义要操作数据库的SQL语句 - 动态多条件查询
        StringBuilder sql = new StringBuilder("select product_id,product_name,product_type,product_price,product_count,product_image,product_date,product_desc,product_sale,product_status,row_number from ( ");
        sql.append("select product_id,product_name,product_type,product_price,product_count,product_image,product_date,product_desc,product_sale,product_status, row_number() over(order by t1.product_id asc) as row_number");
        sql.append(" from product as t1 where 1=1");

        // 1.定义集合，用于存储SQL语句的？占位符的参数值
        List<Object> params = new ArrayList<Object>();

        // 2.拼接SQL语句
        if (product != null && product.getProductName() != null && !"".equals(product.getProductName().trim())) {
            sql.append(" and product_name like ?");
            // 添加条件参数1
            params.add("%" + product.getProductName() + "%");
        }

        if (product != null && product.getProductType() != null && !"".equals(product.getProductType().trim())) {
            sql.append(" and product_type = ?");
            // 添加条件参数2
            params.add(product.getProductType());
        }

        sql.append(") as t2");
        sql.append(" where row_number between  ? and ?");

        // 添加分页参数
        params.add((page - 1) * limit + 1);
        params.add(page * limit);

        // 第二：获取连接对象
        Connection conn = DbUtil4MsSql.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rst = null;

        try {
            // 第三：预编译SQL语句
            pstmt = conn.prepareStatement(sql.toString());

            // 第四：填充占位符中的数据
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(i+1,params.get(i));
            }

            // 第五：执行SQL语句
            rst = pstmt.executeQuery();

            // 第六：对执行的结果进行处理
            while (rst.next()) {
                // 1.读取当前行中各列的数据
                String productId = rst.getString(1);
                String productName = rst.getString(2);
                String productType = rst.getString(3);
                double productPrice = rst.getDouble(4);
                int productCount = rst.getInt(5);
                String productImage = rst.getString(6);
                Timestamp productDate = rst.getTimestamp(7);
                String productDesc = rst.getString(8);
                int productSale = rst.getInt(9);
                int productStatus = rst.getInt(10);

                // 2.实例化实体对象
                Product p = new Product();

                // 3.封装数据，把读取到的各列数据，封装到实体对象中
                p.setProductId(productId);
                p.setProductName(productName);
                p.setProductType(productType);
                p.setProductPrice(productPrice);
                p.setProductCount(productCount);
                p.setProductImage(productImage);
                p.setProductDate(productDate);
                p.setProductDesc(productDesc);
                p.setProductSale(productSale);
                p.setProductStatus(productStatus);

                // 4.把实体对象添加到 List 集合中
                list.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 第七：关闭相关的对象
            DbUtil4MsSql.close(conn, pstmt, rst);
        }
        return list;
    }

    @Override
    public Long selectByPageCount(Product product) {
        Long count = 0L ;

        // 第一：定义要操作数据库的SQL语句 - 动态多条件查询
        StringBuilder sql = new StringBuilder("select count(product_id) from product where 1=1");

        // 1.定义集合，用于存储SQL语句的参数值
        List<Object> params = new ArrayList<Object>();

        // 2.拼接SQL语句
        if (product != null && product.getProductName() != null && !"".equals(product.getProductName().trim())) {
            sql.append(" and product_name like ?");
            // 添加条件参数1
            params.add("%" + product.getProductName() + "%");
        }

        if (product != null && product.getProductType() != null && !"".equals(product.getProductType().trim())) {
            sql.append(" and product_type = ?");
            // 添加条件参数2
            params.add(product.getProductType());
        }

        // 第二：获取连接对象
        Connection conn = DbUtil4MsSql.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rst = null;

        try {
            // 第三：预编译SQL语句
            pstmt = conn.prepareStatement(sql.toString());

            // 第四：填充占位符中的数据
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(i+1,params.get(i));
            }

            // 第五：执行SQL语句
            rst = pstmt.executeQuery();

            // 第六：对执行的结果进行处理
            if (rst.next()) {
                count = rst.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 第七：关闭相关的对象
            DbUtil4MsSql.close(conn, pstmt, rst);
        }
        return count;
    }
}

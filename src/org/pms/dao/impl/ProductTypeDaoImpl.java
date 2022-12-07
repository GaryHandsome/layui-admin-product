package org.pms.dao.impl;

import org.pms.dao.ProductTypeDao;
import org.pms.entity.ProductType;
import org.pms.util.DbUtil4MsSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2022-12-07
 * @Author zqx
 */
public class ProductTypeDaoImpl implements ProductTypeDao {

    @Override
    public List<ProductType> selectAll() {
        List<ProductType> list = new ArrayList<>();
        // 第一：定义要操作数据库的SQL语句
        String sql = "select type_id,type_name,parent_id from product_type";

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
                int typeId = rst.getInt(1);
                String typeName = rst.getString(2);
                int parentId = rst.getInt(3);

                // 2.实例化实体对象
                ProductType pt = new ProductType();
                pt.setTypeId(typeId);
                pt.setTypeName(typeName);
                pt.setParentId(parentId);

                // 3.封装数据，把读取到的各列数据，封装到实体对象中

                // 4.把实体对象添加到 List 集合中
                list.add(pt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 第七：关闭相关的对象
            DbUtil4MsSql.close(conn, pstmt, rst);
        }
        return list;
    }
}

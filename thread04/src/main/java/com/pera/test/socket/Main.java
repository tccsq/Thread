package com.pera.test.socket;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        testJdbc();
    }

    private static void testJdbc() throws Exception {
        //1。注册数据库驱动

        Class.forName("org.postgresql.Driver");
//        Class.forName("com.mysql.jdbc.Driver");
        //2.创建数据库连接
        //url:数据库连接协议
        String json = "{\"count\":3,\"info\":\"OK\",\"status\":1,\"datas\":[{\"_id\":\"33\",\"_location\":\"116.3033897,39.9557559\",\"_name\":\"北京理工大学\",\"_address\":\"http://www.bit.edu.cn\",\"recommended\":\"五颗星\",\"burea\":null,\"telephone\":null,\"_locstatus\":1,\"_createtime\":\"2015-07-20 15:57:35\",\"_updatetime\":\"2015-07-20 15:57:35\",\"_image\":[]},{\"_id\":\"32\",\"_location\":\"116.3472265,39.980086\",\"_name\":\"北京航空航天大学\",\"_address\":\"http://www.buaa.edu.cn\",\"recommended\":\"四颗星\",\"burea\":null,\"telephone\":null,\"_locstatus\":1,\"_createtime\":\"2015-07-20 15:57:35\",\"_updatetime\":\"2015-07-20 15:57:35\",\"_image\":[]},{\"_id\":\"31\",\"_location\":\"116.3006978,39.9713894\",\"_name\":\"中国人民大学\",\"_address\":\"http://www.ruc.edu.cn\",\"recommended\":\"五颗星\",\"burea\":null,\"telephone\":null,\"_locstatus\":1,\"_createtime\":\"2015-07-20 15:57:35\",\"_updatetime\":\"2015-07-20 15:57:35\",\"_image\":[]}]}";
        String url = "jdbc:postgresql://192.168.4.30:5433/mes";
//        String url = "jdbc:mysql://localhost/mes";
        Connection conn = DriverManager.getConnection(url, "postgres", "postgres123");
//        Connection conn = DriverManager.getConnection(url, "root", "root");

        System.out.println(conn);
        //3.建立sql语句发送环境
        Statement stmt = conn.createStatement();
        //4.执行sql语句
        //ResultSet rs=stmt.executeQuery("select * from dept");
        String dname = "SALES' or '1'='1";
        //String dname="SALES' drop table ";
        String sql = "select * from dept where dname ='" + dname + "'";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        //5.遍历结果集
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "-" + rs.getInt("deptno"));

        }
        //6.关闭数据库连接
        rs.close();
        stmt.close();
        conn.close();
    }
}

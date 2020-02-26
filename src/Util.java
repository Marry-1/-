import java.sql.*;

public class Util {
    private static String url = "jdbc:mysql://127.0.0.1:3306/contact?useSSL=false&characterEncoding=UTF-8";
    private static String user = "root"; //数据库用户名
    private static String password = ""; //数据库密码

    public static Connection getConn() throws SQLException, ClassNotFoundException {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Statement stat, Connection conn, ResultSet res) {
        //关闭结果集
        if( stat != null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //关闭命令
        if( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //关闭连接
        if( res != null){
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}





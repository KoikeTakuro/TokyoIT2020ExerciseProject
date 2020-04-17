package jp.co.sss.emanage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * DB接続処理用クラス
 *
 * @author System Shared
 *
 */
public class DBManager {

    /**
     * DB接続メソッド
     *
     * @return 接続情報
     */
    public static Connection getConnection() {

        try {
            // JDBCドライバクラスをJVMに登録
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // DBへ接続
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE", "employee_user",
                    "systemsss");
            return con;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * @param ps
     *            preparedStatement
     * @param con
     *            接続情報
     */
    public static void close(PreparedStatement ps, Connection con) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

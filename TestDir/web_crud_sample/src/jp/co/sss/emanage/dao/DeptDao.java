package jp.co.sss.emanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.emanage.bean.DeptBean;

/**
 * 部署テーブル用DAO
 *
 * @author System Shared
 *
 */
public class DeptDao {

    /** 部署IDによるdepartmentの検索SQL */
    private static final String DEPT_FIND_BY_ID = "SELECT dept_id, dept_name FROM department WHERE dept_id = ?";
    /** departmentの検索SQL */
    private static final String DEPT_FIND_ALL = "SELECT dept_id,dept_name FROM department d ORDER BY dept_id";
    /** departmentの変更SQL */
    private static final String DEPT_UPDATE = "UPDATE department SET dept_name = ? WHERE dept_id = ?";
    /** departmentの削除SQL */
    private static final String DEPT_DELETE = "DELETE FROM department WHERE dept_id = ?";
    /** departmentの登録SQL */
    private static final String DEPT_INSERT = "INSERT INTO department(dept_id,dept_name)VALUES(seq_dept.nextval,?)";

    /**
     * 部署IDによる1件検索メソッド
     *
     * @param deptId
     *            部署ID
     * @return 部署テーブルのbean
     */
    public static DeptBean findById(String deptId) {

        // 接続準備
        Connection con = null;
        PreparedStatement ps = null;
        DeptBean deptBean = null;

        try {
            // DBに接続
            con = DBManager.getConnection();

            // SQL文を準備
            ps = con.prepareStatement(DEPT_FIND_BY_ID);

            // 部署IDを検索条件に設定
            ps.setString(1, deptId);

            // SQL文を実行
            ResultSet rs = ps.executeQuery();

            // 検索結果をbeanに格納する
            if (rs.next()) {
                deptBean = new DeptBean();
                deptBean.setDeptId(rs.getString("dept_id"));
                deptBean.setDeptName(rs.getString("dept_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // DB切断処理
            DBManager.close(ps, con);
        }
        return deptBean;
    }

    /**
     * 部署テーブル全件検索メソッド
     *
     * @return 部署テーブル全件のリスト
     */
    public static List<DeptBean> findAll() {

        Connection con = null;
        PreparedStatement ps = null;

        // 全件を格納するリストを準備しておく
        List<DeptBean> deptList = new ArrayList<DeptBean>();

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(DEPT_FIND_ALL);
            ResultSet rs = ps.executeQuery();

            // プルダウンの初期値用に各プロパティがnullのbeanをリストへ詰める
            DeptBean zeroDeptBean = new DeptBean();
            deptList.add(zeroDeptBean);

            // 検索結果をbeanに格納し、そのbeanをリストに詰める
            while (rs.next()) {
                DeptBean deptBean = new DeptBean();
                deptBean.setDeptId(rs.getString("dept_id"));
                deptBean.setDeptName(rs.getString("dept_name"));
                deptList.add(deptBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return deptList;
    }

    /**
     * 部署情報変更メソッド
     *
     * @param deptBean
     *            変更するの社員のbean
     */
    public static void update(DeptBean deptBean) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(DEPT_UPDATE);

            ps.setString(1, deptBean.getDeptName()); // 部署名を設定
            ps.setString(2, deptBean.getDeptId()); // 変更する部署のIDを設定

            // UPDATEを実行
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return;
    }

    /**
     * 部署情報削除メソッド
     *
     * @param deptId
     *            削除する社員のID
     */
    public static void delete(String deptId) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(DEPT_DELETE);

            ps.setString(1, deptId); // 削除する社員のIDを設定

            // DELETEを実行
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return;
    }

    /**
     * 部署情報新規登録メソッド
     *
     * @param empBean
     *            登録する部署のbean
     */
    public static void insert(DeptBean deptBean) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(DEPT_INSERT);

            ps.setString(1, deptBean.getDeptName()); // 部署名を設定

            // INSERTを実行
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return;
    }
}

package jp.co.sss.emanage.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.DeptBean;
import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.DeptDao;
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.form.ManageSelectForm;
import jp.co.sss.emanage.util.Property;

/**
 * 社員情報検索画面クラス
 *
 * @author System Shared
 */
@WebServlet("/ManageSelectServlet")
public class ManageSelectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageSelectServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // 入力された検索情報を受け取るフォームの準備
        ManageSelectForm manageSelectForm = new ManageSelectForm();

        // 条件検索キーを取得(ラジオボタンの値)
        manageSelectForm.setFindKey(request.getParameter("radio"));

        // 全件を格納するリストを準備しておく
        List<EmpBean> empList = null;

        // 部署テーブルの全件を取得
        List<DeptBean> deptList = DeptDao.findAll();

        // 部署テーブルの全件が入ったリストをリクエスト属性に登録しておく
        request.setAttribute("deptList", deptList);

        // 条件検索キーが選択されていなかった場合
        if (manageSelectForm.getFindKey() == null) {
            // 社員テーブルを検索し、全項目を取得する
            empList = EmpDao.findAll();

            // 検索結果の入ったリストをリクエスト属性に登録しておく
            request.setAttribute("empList", empList);

            // 検索キーが入力されていない場合,社員全件表示画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("jsp/manage/manage.jsp");
            dispatcher.forward(request, response);
        }

        // 管理者権限の社員ID検索表示を行う
        else if (Property.KEY_SELECT_BY_EMP_ID.equals(manageSelectForm
                .getFindKey())) {
            // フォームから社員IDを取得し、社員ID検索による取得
            manageSelectForm.setEmpId(request.getParameter("empId"));
            EmpBean empBean = EmpDao.findById(manageSelectForm.getEmpId());

            // 検索結果がある場合
            if (empBean != null) {
                // 一覧表示のためにリストに入れる
                empList = new ArrayList<EmpBean>();
                empList.add(empBean);

                // それぞれの条件検索による取得されたリストをリクエスト属性に登録しておく
                request.setAttribute("empList", empList);
                // 社員情報一覧表示画面へ遷移する
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("jsp/manage/manage.jsp");
                dispatcher.forward(request, response);
            }

            // 検索結果が0件の場合
            else if (empList == null || empList.isEmpty()) {
                // エラーページへと遷移する
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("jsp/select/not_found.jsp");
                dispatcher.forward(request, response);
            }
        }
        // 管理者権限の社員名検索表示を行う
        else if (Property.KEY_SELECT_BY_EMP_NAME.equals(manageSelectForm
                .getFindKey())) {

            // フォームから社員名を取得し、社員名検索によるリスト取得
            manageSelectForm.setEmpName(request.getParameter("empName"));
            empList = EmpDao.findByNameContains(manageSelectForm.getEmpName());

            // 検索結果がある場合
            if (empList != null && !empList.isEmpty()) {
                // それぞれの条件検索による取得されたリストをリクエスト属性に登録しておく
                request.setAttribute("empList", empList);
                // 社員情報一覧表示画面へ遷移する
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("jsp/manage/manage.jsp");
                dispatcher.forward(request, response);
            }

            // 検索結果が0件の場合
            else if (empList == null || empList.isEmpty()) {
                // エラーページへと遷移する
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("jsp/select/not_found.jsp");
                dispatcher.forward(request, response);
            }
        }

        // 管理者権限の部署ID検索表示を行う
        else if (Property.KEY_SELECT_BY_DEPT_ID.equals(manageSelectForm
                .getFindKey())) {
            // フォームから部署IDを取得し、部署ID検索によるリスト取得
            manageSelectForm.setDeptId(request.getParameter("deptId"));
            empList = EmpDao.findByDeptId(manageSelectForm.getDeptId());

            // 検索結果がある場合
            if (empList != null && !empList.isEmpty()) {
                // それぞれの条件検索による取得されたリストをリクエスト属性に登録しておく
                request.setAttribute("empList", empList);
                // 社員情報一覧表示画面へ遷移する
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("jsp/manage/manage.jsp");
                dispatcher.forward(request, response);
            }
            // 検索結果が0件の場合
            else if (empList == null || empList.isEmpty()) {
                // エラーページへと遷移する
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("jsp/select/not_found.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}

package jp.co.sss.emanage.dept;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.DeptBean;
import jp.co.sss.emanage.dao.DeptDao;

/**
 * 部署情報削除確認画面クラス
 *
 * @author System Shared
 */
@WebServlet("/DeleteDeptConfirmServlet")
public class DeleteDeptConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDeptConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // 所属人数を受け取る
        String affiliation = request.getParameter("affiliation");

        // 部署に所属している人がいる場合はエラーページに遷移
        if (!affiliation.equals("0")) {

            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("jsp/dept/dept_delete_error.jsp");
            dispatcher.forward(request, response);

        } else {
            // 削除対象のIDを受け取る
            String id = request.getParameter("deptId");

            // 削除する社員情報の全項目について検索して取得する
            DeptBean deptBean = DeptDao.findById(id);

            // 検索結果の入ったリストをリクエスト属性に登録しておく
            request.setAttribute("dept", deptBean);

            // 削除情報確認画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("jsp/dept/dept_delete_confirm.jsp");
            dispatcher.forward(request, response);
        }

    }
}

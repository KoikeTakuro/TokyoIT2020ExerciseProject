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
import jp.co.sss.emanage.form.DeptForm;

/**
 * 部署情報更新入力画面クラス
 *
 * @author System Shared
 */
@WebServlet("/UpdateDeptInputServlet")
public class UpdateDeptInputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDeptInputServlet() {
        super();
    }

      protected void doGet(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {

        // 更新対象のIDを受け取る
            String id = request.getParameter("deptId");

            // 更新する社員情報の全項目について検索して取得する
            DeptBean deptBean = DeptDao.findById(id);

         // 検索結果の入ったリストをリクエスト属性に登録しておく
            request.setAttribute("dept", deptBean);

            // 入力フォームクラスの宣言
            DeptForm deptForm = new DeptForm();
            deptForm.setDeptId(deptBean.getDeptId());
            deptForm.setDeptName(deptBean.getDeptName());

            // 検索結果の入ったリストをリクエスト属性に登録しておく
            request.setAttribute("deptForm", deptForm);

         // 更新情報入力画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("jsp/dept/dept_update_input.jsp");
            dispatcher.forward(request, response);
        }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // 更新対象のIDを受け取る
        String id = request.getParameter("deptId");

        // 更新する社員情報の全項目について検索して取得する
        DeptBean deptBean = DeptDao.findById(id);

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("dept", deptBean);

        // 入力フォームクラスの宣言
        DeptForm deptForm = new DeptForm();
        deptForm.setDeptId(request.getParameter("deptId"));
        deptForm.setDeptName(request.getParameter("deptName"));

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("deptForm", deptForm);

        // 更新情報入力画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("jsp/dept/dept_update_input.jsp");
        dispatcher.forward(request, response);
    }

}

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
 * 部署情報更新完了画面クラス
 *
 * @author System Shared
 */
@WebServlet("/UpdateDeptCompleteServlet")
public class UpdateDeptCompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDeptCompleteServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // 変更処理で利用するbeanを用意しておく
        DeptBean deptBean = new DeptBean();

        // 入力された変更情報を受け取り、Beanに値を詰める
        deptBean.setDeptId(request.getParameter("deptId"));
        deptBean.setDeptName(request.getParameter("deptName"));

        // 変更処理を実行する
        DeptDao.update(deptBean);

        // 変更完了画面に遷移
        // 変更情報確認画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("jsp/dept/dept_update_complete.jsp");
        dispatcher.forward(request, response);
    }
}

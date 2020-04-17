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
 * 部署情報登録完了画面クラス
 *
 * @author System Shared
 */
@WebServlet("/InsertDeptCompleteServlet")
public class InsertDeptCompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDeptCompleteServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // 登録処理で利用するbeanを用意しておく
        DeptBean deptBean = new DeptBean();

        // 入力された登録情報を受け取り、Beanに値を詰める
        deptBean.setDeptName(request.getParameter("deptName"));

        // 登録処理を実行する
        DeptDao.insert(deptBean);

        // 登録完了画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("jsp/dept/dept_insert_complete.jsp");
        dispatcher.forward(request, response);
    }

}

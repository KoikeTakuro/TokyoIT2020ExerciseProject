package jp.co.sss.emanage.dept;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.dao.DeptDao;

/**
 * 部署情報削除完了画面クラス
 *
 * @author System Shared
 */
@WebServlet("/DeleteDeptCompleteServlet")
public class DeleteDeptCompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDeptCompleteServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // 削除対象のIDを受け取る
        String id = request.getParameter("deptId");

        // 削除対象情報の社員IDを利用して削除を実行する
        DeptDao.delete(id);

        // 削除完了画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("jsp/dept/dept_delete_complete.jsp");
        dispatcher.forward(request, response);
    }

}

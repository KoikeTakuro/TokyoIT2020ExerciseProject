package jp.co.sss.emanage.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;

/**
 * 部署情報一覧画面クラス
 *
 * @author System Shared
 */
@WebServlet("/DeptManageServlet")
public class DeptManageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptManageServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // 社員テーブルを検索し、部署関連の情報を全て取得する
        List<EmpBean> empList = EmpDao.findEmployeeDeptAll();

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("empList", empList);

        // 管理者用一覧表示画面へ画面遷移を行う
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("jsp/dept/dept.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        // 社員テーブルを検索し、部署関連の情報を全て取得する
        List<EmpBean> empList = EmpDao.findEmployeeDeptAll();

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("empList", empList);

        // 管理者用一覧表示画面へ画面遷移を行う
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("jsp/dept/dept.jsp");
        dispatcher.forward(request, response);

    }

}

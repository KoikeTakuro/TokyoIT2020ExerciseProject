package jp.co.sss.emanage.manage;

import java.io.IOException;
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
 * 社員情報一覧画面クラス
 *
 * @author System Shared
 */
@WebServlet("/ManageTopServlet")
public class ManageTopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageTopServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         // 社員テーブルを検索し、全項目を取得する
        List<EmpBean> empList = EmpDao.findAll();

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("empList", empList);

        // 条件検索キーの初期値をリクエストに格納
        ManageSelectForm manageForm = new ManageSelectForm();
        manageForm.setFindKey(Property.FINDKEY_EMP_ID);
        request.setAttribute("manageForm", manageForm);

        // 部署テーブルの全件を取得
        List<DeptBean> deptList = DeptDao.findAll();

        // 部署テーブルの全件が入ったリストをセッション属性に登録しておく
        request.setAttribute("deptList", deptList);

        // 管理者用一覧表示画面へ画面遷移を行う
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("jsp/manage/manage.jsp");
        dispatcher.forward(request, response);
    }
}

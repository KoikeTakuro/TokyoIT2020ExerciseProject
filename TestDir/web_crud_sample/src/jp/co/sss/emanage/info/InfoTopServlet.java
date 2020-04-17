package jp.co.sss.emanage.info;

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
import jp.co.sss.emanage.form.SelfSelectForm;
import jp.co.sss.emanage.util.Property;

/**
 * 社員情報一覧画面クラス（一般）
 *
 * @author System Shared
 */
@WebServlet("/InfoTopServlet")
public class InfoTopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoTopServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // 社員テーブルを検索し、社員ID、社員名、部署名のみ取得する
        List<EmpBean> empInfoList = EmpDao.findLimitedEmpInfo();

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("empList", empInfoList);

        // 部署テーブルの全件を取得
        List<DeptBean> deptList = DeptDao.findAll();

        // 部署テーブルの全件が入ったリストをリクエスト属性に登録しておく
        request.setAttribute("deptList", deptList);

        // 条件検索キーの初期値をリクエスト属性に登録しておく
        SelfSelectForm selfSelectForm = new SelfSelectForm();
        selfSelectForm.setFindKey(Property.FINDKEY_EMP_ID);
        request.setAttribute("selfSelectForm", selfSelectForm);

        // 一般社員用一覧表示画面へ画面遷移を行う
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("jsp/info/info.jsp");
        dispatcher.forward(request, response);
    }
}

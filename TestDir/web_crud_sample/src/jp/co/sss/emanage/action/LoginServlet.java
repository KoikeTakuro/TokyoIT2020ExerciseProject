package jp.co.sss.emanage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.emanage.bean.DeptBean;
import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.DeptDao;
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.form.ManageSelectForm;
import jp.co.sss.emanage.form.SelfSelectForm;
import jp.co.sss.emanage.util.Property;

/**
 * ログイン画面クラス
 *
 * @author System Shared
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        try {
            // setCharacterEncodingメソッドを使って受け取った文字列の文字コードを指定
            request.setCharacterEncoding("UTF-8");

            // セッションを利用する準備
            HttpSession session = request.getSession(false);

            // セッション属性に登録されているユーザー情報をクリア
            session.removeAttribute("user");

            String id = request.getParameter("empId");
            String password = request.getParameter("empPass");

            // 入力されたID、パスワードで検索する
            EmpBean empBean = EmpDao.findByIdPass(id, password);

            // 該当する社員が見つかり、かつ一般権限だった場合
            if (empBean != null
                    && empBean.getAuthority().equals(Property.EMPLOYEE)) {

                // セッション属性にログインしたユーザーの情報を登録しておく
                session.setAttribute("user", empBean);

                // 社員テーブルを検索し、社員ID、社員名、部署名のみ取得する
                List<EmpBean> empInfoList = EmpDao.findLimitedEmpInfo();

                // 検索結果の入ったリストをリクエスト属性に登録しておく
                request.setAttribute("empList", empInfoList);

                // 条件検索キーの初期値をリクエストに格納
                SelfSelectForm selfSelectForm = new SelfSelectForm();
                selfSelectForm.setFindKey(Property.FINDKEY_EMP_ID);
                request.setAttribute("selfSelectForm", selfSelectForm);

                // 部署テーブルの全件を取得
                List<DeptBean> deptList = DeptDao.findAll();

                // 部署テーブルの全件が入ったリストをセッション属性に登録しておく
                request.setAttribute("deptList", deptList);

                // 一般社員用一覧表示画面へ画面遷移を行う
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("jsp/info/info.jsp");
                dispatcher.forward(request, response);

                // 該当する社員が見つかり、かつ管理者権限だった場合
            } else if (empBean != null
                    && empBean.getAuthority().equals(Property.MANAGER)) {

                session.setAttribute("user", empBean);

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

                // 該当する社員が見つからなかった場合（ログインエラー）
            } else {

                request.setAttribute("errorMessage", "ユーザ名またはパスワードが違います");

                // ログイン画面へ遷移を行う
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            // エラー画面へ遷移を行う
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/jsp/error/error.jsp");
            dispatcher.forward(request, response);
        }
    }

}

package jp.co.sss.emanage.dept;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.form.DeptForm;
import jp.co.sss.emanage.util.InputValidator;

/**
 * 部署情報登録確認画面クラス
 *
 * @author System Shared
 */
@WebServlet("/InsertDeptConfirmServlet")
public class InsertDeptConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDeptConfirmServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // 入力フォームクラスの宣言
        DeptForm deptForm = new DeptForm();

        // 入力された変更情報を受け取る
        deptForm.setDeptName(request.getParameter("deptName"));

        // 入力チェッククラスの宣言
        InputValidator inputValidator = new InputValidator();
        String check = inputValidator.deptNameValidate(deptForm.getDeptName());

        // エラーメッセージがある場合
        if (check != null) {
            request.setAttribute("errorName", check);

            // 入力情報の入ったリストをリクエスト属性に登録しておく
            request.setAttribute("deptForm", deptForm);
            // 入力情報に誤りがあるため、入力画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("jsp/dept/dept_insert_input.jsp");
            dispatcher.forward(request, response);
        } else {

            // 入力情報の入ったリストをリクエスト属性に登録しておく
            request.setAttribute("deptForm", deptForm);

            // 登録情報確認画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("jsp/dept/dept_insert_confirm.jsp");
            dispatcher.forward(request, response);
        }
    }

}

package jp.co.sss.emanage.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ログアウト画面クラス
 *
 * @author System Shared
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // セッションを利用する準備
        HttpSession session = request.getSession();

        // セッション属性に登録されているユーザー情報をクリア
        session.removeAttribute("user");

        // ログイン画面へ遷移を行う
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}

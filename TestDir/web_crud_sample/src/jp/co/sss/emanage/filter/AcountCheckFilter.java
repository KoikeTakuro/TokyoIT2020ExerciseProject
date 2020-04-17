package jp.co.sss.emanage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.emanage.bean.EmpBean;

/**
 * アカウント確認用フィルター
 *
 * @author System Shared
 *
 */
public class AcountCheckFilter implements Filter {
    ServletContext context;

    /**
     * Default constructor.
     */
    public AcountCheckFilter() {

    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {

    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        // セッションを利用する準備
        HttpSession session = ((HttpServletRequest) request).getSession();

        // 遷移先のパスを取得
        String target = ((HttpServletRequest) request).getRequestURI();

        // セッション属性に登録してあるログインユーザーの情報を取得
        EmpBean empBean = (EmpBean) session.getAttribute("user");

        // ログインページにリダイレクトするか判定するためのフラグ
        boolean isRedirect = false;

        // セッションにログイン情報が登録されていなかった場合
        if (empBean == null) {
            // リダイレクトフラグをtrue
            isRedirect = true;

//            // 管理者用ページに遷移しようとしていて、かつ管理者の権限を持っていなかった場合
//        } else if (target.startsWith(context.getContextPath() + "/manage")
//                && !(empBean.getAuthority().equals("2"))) {
//            // リダイレクトフラグをtrue
//            isRedirect = true;
        }

        // リダイレクトフラグがtrueであった場合
        if (isRedirect) {
            // ログインページにリダイレクトする
            ((HttpServletResponse) response)
                    .sendRedirect(((HttpServletRequest) request)
                            .getContextPath());
        } else {
            // それ以外はそのまま遷移させる
            chain.doFilter(request, response);
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
    }
}

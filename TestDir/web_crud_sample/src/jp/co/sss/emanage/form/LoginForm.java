package jp.co.sss.emanage.form;

/**
 * ログイン情報フォームクラス
 *
 * @author System Shared
 */
public class LoginForm {

    /** 社員ID */
    private String empId;
    /** パスワード */
    private String empPass;

    /**
     * @return 社員ID
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId
     *            社員ID
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * @return パスワード
     */
    public String getEmpPass() {
        return empPass;
    }

    /**
     * @param empPass
     *            パスワード
     */
    public void setEmpPass(String empPass) {
        this.empPass = empPass;
    }
}

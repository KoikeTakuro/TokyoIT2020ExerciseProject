package jp.co.sss.emanage.form;

/**
 * 登録情報フォームクラス
 *
 * @author System Shared
 */
public class InsertForm {

    /** 社員ID */
    private String empId;
    /** パスワード */
    private String empPass;
    /** 社員名 */
    private String empName;
    /** 性別 */
    private String gender;
    /** 住所 */
    private String address;
    /** 生年月日 */
    private String birthday;
    /** 権限 */
    private String authority;
    /** 部署ID */
    private String deptId;
    /** 部署名 */
    private String deptName;

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

    /**
     * @return 社員名
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName
     *            社員名
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return 性別
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     *            性別
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return 住所
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *            住所
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return 生年月日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     *            生年月日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return 権限
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * @param authority
     *            権限
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * @return 部署ID
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * @param deptId
     *            部署ID
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * @return 部署名
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName
     *            部署名
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}

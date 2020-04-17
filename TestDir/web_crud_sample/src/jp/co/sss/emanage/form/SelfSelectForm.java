package jp.co.sss.emanage.form;

/**
 * 検索情報フォームクラス（一般）
 *
 * @author System Shared
 */
public class SelfSelectForm {

    /** 社員ID */
    private String empId;
    /** 社員名 */
    private String empName;
    /** 部署ID */
    private String deptId;
    /** 検索キー */
    private String findKey;

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
     * @return 社員名
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empId
     *            社員名
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return 部署ID
     */
    public String getDeptId() {

        return deptId;
    }

    /**
     * @param empId
     *            部署ID
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * @return 検索キー
     */
    public String getFindKey() {
        return findKey;
    }

    /**
     * @param findKey
     *            検索キー
     */
    public void setFindKey(String findKey) {
        this.findKey = findKey;
    }
}

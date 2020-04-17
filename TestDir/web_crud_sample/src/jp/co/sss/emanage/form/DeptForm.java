package jp.co.sss.emanage.form;

/**
 * 部署情報フォームクラス
 *
 * @author System Shared
 */
public class DeptForm {

    /** 部署ID */
    private String deptId;
    /** 部署名 */
    private String deptName;
    /** 検索キー */
    private String findKey;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getFindKey() {
        return findKey;
    }

    public void setFindKey(String findKey) {
        this.findKey = findKey;
    }

}

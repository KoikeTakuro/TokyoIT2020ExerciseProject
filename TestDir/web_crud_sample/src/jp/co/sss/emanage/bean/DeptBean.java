package jp.co.sss.emanage.bean;

import java.io.Serializable;

/**
 * 部署テーブル用bean
 *
 * @author System Shared
 *
 */
public class DeptBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 部署ID */
    private String deptId;
    /** 部署名 */
    private String deptName;

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

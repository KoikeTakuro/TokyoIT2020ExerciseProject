package jp.co.sss.emanage.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author SystemShared 入力チェックを行い、エラーメッセージを格納するクラス
 *         エラーメッセージを編集する場合はPropertyクラスの定数を修正すること
 */
public class InputValidator {

    /**
     * @param password
     * @return パスワードのチェックを行うメソッド
     */
    public String passwordValidate(String password) {
        String error = null;

        if (password == null || password.isEmpty()) {
            error = Property.PASSWORD_EMPTY;
        } else if (password.length() > 15) {
            error = Property.PASSWORD_LENGTH_OVER;
        }
        return error;
    }

    /**
     * @param name
     * @return 社員名のチェックを行うメソッド
     */
    public String nameValidate(String name) {
        String error = null;

        if (name == null || name.isEmpty()) {
            error = Property.NAME_EMPTY;
        } else if (name.length() > 15) {
            error = Property.NAME_LENGTH_OVER;
        }
        return error;
    }

    /**
     * @param gender
     * @return 性別のチェックを行うメソッド
     */
    public String genderValidate(String gender) {
        String error = null;

        if (gender == null || gender.isEmpty()) {
            error = Property.GENDER_EMPTY;
        } else if (!gender.equals("1") && !gender.equals("2")) {
            error = Property.GENDER_MISSMATCH;
        }
        return error;
    }

    /**
     * @param address
     * @return 住所のチェックを行うメソッド
     */
    public String addressValidate(String address) {
        String error = null;

        if (address == null || address.isEmpty()) {
            error = Property.ADDRESS_EMPTY;
        } else if (address.length() > 30) {
            error = Property.ADDRESS_LENGTH_OVER;
        }
        return error;
    }

    /**
     * @param birthday
     * @return 生年月日のチェックを行うメソッド
     */
    public String birthdayValidate(String birthday) {
        String error = null;

        if (birthday == null || birthday.isEmpty()) {
            error = Property.BIRTHDAY_EMPTY;
        } else if (!(birthday.length() == 10)) {
            error = Property.BIRTHDAY_MISSMATCH;
        } else if (!isBirthday(birthday)) {
            error = Property.BIRTHDAY_MISSMATCH;
        }
        return error;
    }

    /**
     * @param authority
     * @return 権限のチェックを行うメソッド
     */
    public String authorityValidate(String authority) {
        String error = null;

        if (authority == null || authority.isEmpty()) {
            error = Property.AUTHORITY_EMPTY;
        } else if (!authority.equals("1") && !authority.equals("2")) {
            error = Property.AUTHORITY_MISSMATCH;
        }
        return error;
    }

    /**
     * @param deptId
     * @return 部署のチェックを行うメソッド
     */
    public String deptIdValidate(String deptId) {
        String error = null;

        if (deptId == null || deptId.isEmpty()) {
            error = Property.DEPT_EMPTY;
        } else if (!isNumber(deptId)) {
            error = Property.DEPT_MISSMATCH;
        }
        return error;
    }

    /**
     * @param name
     * @return 部署名のチェックを行うメソッド
     */
    public String deptNameValidate(String name) {
        String error = null;

        if (name == null || name.isEmpty()) {
            error = Property.NAME_EMPTY;
        } else if (name.length() > 15) {
            error = Property.NAME_LENGTH_OVER;
        }
        return error;
    }

    /**
     * @param birthday
     * @return 生年月日に数字以外が含まれていないかチェックするメソッド 正規表現を使用
     */
    public static boolean isBirthday(String birthday) {
        Pattern p = Pattern.compile(Property.BIRTHDAY_MATCH_CHECK);
        Matcher m = p.matcher(birthday);
        return m.find();
    }

    /**
     * @param id
     * @return 数値以外のものが入っていないかをチェックするメソッド 正規表現を使用
     */
    public static boolean isNumber(String id) {
        Pattern p = Pattern.compile(Property.NUMBER_MATCH_CHECK);
        Matcher m = p.matcher(id);
        return m.find();
    }
}

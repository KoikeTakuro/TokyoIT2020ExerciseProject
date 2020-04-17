package jp.co.sss.emanage.util;

/**
 * 定数をまとめたクラス
 *
 * @author System Shared
 *
 */
public class Property {

    /** 一般社員の権限を表す */
    public static final String EMPLOYEE = "1";

    /** 管理者の権限を表す */
    public static final String MANAGER = "2";

    /** 条件検索キーの社員IDの初期値 */
    public static final String FINDKEY_EMP_ID = "1";

    /** 社員IDによる検索 */
    public static final String KEY_SELECT_BY_EMP_ID = "1";

    /** 社員名による検索 */
    public static final String KEY_SELECT_BY_EMP_NAME = "2";

    /** 部署IDによる検索 */
    public static final String KEY_SELECT_BY_DEPT_ID = "3";

    /** パスワードが未入力のエラーメッセージ */
    public static final String PASSWORD_EMPTY = "パスワードが未入力です";

    /** パスワードの入力文字が15文字以上の場合のエラーメッセージ */
    public static final String PASSWORD_LENGTH_OVER = "パスワードが長すぎます";

    /** 名前が未入力のエラーメッセージ */
    public static final String NAME_EMPTY = "名前が未入力です";

    /** 名前の入力文字が15文字以上の場合のエラーメッセージ */
    public static final String NAME_LENGTH_OVER = "名前が長すぎます";

    /** 性別が未選択のエラーメッセージ */
    public static final String GENDER_EMPTY = "性別が未選択です";

    /** 性別の値が予期しない値時のエラーメッセージ */
    public static final String GENDER_MISSMATCH = "性別の値が不正です";

    /** 住所が未入力のエラーメッセージ */
    public static final String ADDRESS_EMPTY = "住所が未入力です";

    /** 住所の入力文字が30文字以上の場合のエラーメッセージ */
    public static final String ADDRESS_LENGTH_OVER = "住所が長すぎます";

    /** 生年月日が未入力のエラーメッセージ */
    public static final String BIRTHDAY_EMPTY = "生年月日が未入力です";

    /** 生年月日の値が予期しない値時のエラーメッセージ */
    public static final String BIRTHDAY_MISSMATCH = "生年月日は(YYYY/MM/DD)形式で入力してください";

    /** 権限が未選択のエラーメッセージ */
    public static final String AUTHORITY_EMPTY = "権限が未選択です";

    /** 権限の値が予期しない値時のエラーメッセージ */
    public static final String AUTHORITY_MISSMATCH = "権限の値が不正です";

    /** 部署が未選択のエラーメッセージ */
    public static final String DEPT_EMPTY = "部署名が未選択です";

    /** 部署の値が予期しない値時のエラーメッセージ */
    public static final String DEPT_MISSMATCH = "部署名の値が不正です";

    /** 生年月日の入力値をチェックする正規表現 */
    public static final String BIRTHDAY_MATCH_CHECK = "^(\\d{4})/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$";

    /** 数値以外のものが入っていないかをチェックする正規表現 */
    public static final String NUMBER_MATCH_CHECK = "^[0-9]+$";

    /** パスワードが一致している確認し、一致しない場合のエラーメッセージ */
    public static final String PASSWORD_MISMATCH = "入力されたパスワードの値が一致しません";

    /** 現在のパスワードと入力が一致している確認し、一致しない場合のエラーメッセージ */
    public static final String NOW_PASSWORD_MISMATCH = "入力されたパスワードの値が現在のパスワードと一致しません";

}

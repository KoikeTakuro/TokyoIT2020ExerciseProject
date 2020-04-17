package jp.co.sss.emanage.util;

/**
 * 日付形式を変換するためのクラス
 *
 * @author System Shared
 *
 */
public class DateFormat {
    /**
     * 日本形式の日付(yyyy年MM月dd日)を yyyy-mm-ddの形式へと変換するメソッド
     *
     * @param 日付
     *            (yyyy年MM月dd日形式)
     *
     * @return 日付(yyyy-MM-dd形式)
     */
    public static String formatDate(String dateJP) {

        // 戻り値dateを初期化
        String date = "";

        // yyyy年MM月dd日の形式から年月日だけを取り出して、それぞれの変数へ代入
        String yearStr = dateJP.substring(0, 4);
        String monthStr = dateJP.substring(5, 7);
        String dayStr = dateJP.substring(8, 10);

        // 取り出した変数をyyyy-MM-ddへと並び替える。
        date = yearStr + "-" + monthStr + "-" + dayStr;

        return date;

    }

    /**
     * @param selectDate
     * 登録情報を更新する際に使用
     * 表記を/に変更するメソッド
     * @return
     */
    public static String selectFormatDate(String selectDate){

        selectDate = selectDate.replace('年', '/');
        selectDate = selectDate.replace('月', '/');
        selectDate = selectDate.substring(0,selectDate.length()-1);

        return selectDate;

    }

}
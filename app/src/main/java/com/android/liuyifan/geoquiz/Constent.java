package com.android.liuyifan.geoquiz;

/**
 * Created by DELL on 2016/12/6.
 */
public class Constent {
    public static class Table{
        public static final String TAB_NAME = "GeoQuiz";
        public static final String TAB_COL_URL = "GeoQuiz_URL";
        public static final String TAB_COL_IMGURL = "GeoQuiz_IMGURL";
        public static String getTableSQLite(){
            String sq = "create table if not exists "
                    + TAB_NAME
                    + " ( "
                    + " _id integer primary key autoincrement , "
                    + TAB_COL_URL + " text , "
                    + TAB_COL_IMGURL + " text "
                    + " ) ";
            return sq;
        }
    }
}

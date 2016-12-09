package com.android.liuyifan.geoquiz;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL on 2016/12/6.
 */
public class SQLiteHelp extends SQLiteOpenHelper {
    public SQLiteHelp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public SQLiteHelp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sq = Constent.Table.getTableSQLite();
        db.execSQL(sq);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sq = " drop table " + Constent.Table.TAB_NAME;
        db.execSQL(sq);
        onCreate(db);
    }
}

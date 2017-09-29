package com.example.administrator.orm_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.administrator.orm_test.bean.CDG_EDUCATIONALLEVEL;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {



    private static final String TAG = "DatabaseHelper";
    // 数据库名称
    private static final String DATABASE_NAME = "HelloOrmlite.db";
    // 数据库version
    private static final int DATABASE_VERSION = 1;

    private Dao<CDG_EDUCATIONALLEVEL, Integer> cDG_EDUCATIONALLEVELDao = null;
    private RuntimeExceptionDao<CDG_EDUCATIONALLEVEL, Integer> cDG_EDUCATIONALLEVELRuntimeDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // 可以用配置文件来生成 数据表，有点繁琐，不喜欢用
        // super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    /**
     * @param context
     * @param databaseName
     * @param factory
     * @param databaseVersion
     */
    public DatabaseHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        super(context, databaseName, factory, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            //建立CDG_EDUCATIONALLEVEL表
            //			TableUtils.createTable(connectionSource, CDG_EDUCATIONALLEVEL.class);

            TableUtils.createTableIfNotExists(connectionSource, CDG_EDUCATIONALLEVEL.class);
            //初始化DAO
            cDG_EDUCATIONALLEVELDao = getCDG_EDUCATIONALLEVELDao();
            cDG_EDUCATIONALLEVELRuntimeDao = getCDG_EDUCATIONALLEVELDataDao();
        } catch (SQLException e) {
            Log.e(TAG, e.toString());
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, CDG_EDUCATIONALLEVEL.class, true);
        } catch (SQLException e) {
            Log.e(TAG, e.toString());
            e.printStackTrace();
        }
    }

    /**
     * @return
     * @throws SQLException
     */
    private Dao<CDG_EDUCATIONALLEVEL, Integer> getCDG_EDUCATIONALLEVELDao() throws SQLException {
        if (cDG_EDUCATIONALLEVELDao == null)
            cDG_EDUCATIONALLEVELDao = getDao(CDG_EDUCATIONALLEVEL.class);
        return cDG_EDUCATIONALLEVELDao;
    }

    public RuntimeExceptionDao<CDG_EDUCATIONALLEVEL, Integer> getCDG_EDUCATIONALLEVELDataDao() {
        if (cDG_EDUCATIONALLEVELRuntimeDao == null) {
            cDG_EDUCATIONALLEVELRuntimeDao = getRuntimeExceptionDao(CDG_EDUCATIONALLEVEL.class);
        }
        return cDG_EDUCATIONALLEVELRuntimeDao;
    }

    /**
     * 释放 DAO
     */
    @Override
    public void close() {
        super.close();
        cDG_EDUCATIONALLEVELRuntimeDao = null;
    }

}

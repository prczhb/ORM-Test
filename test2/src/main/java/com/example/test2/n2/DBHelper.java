package com.example.test2.n2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.example.test2.R;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/7/18.
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {
    public static final String DB_DIR = Environment
            .getExternalStorageDirectory().getAbsolutePath() + "/orm/";
    public static final String DB_NAME = "orm.db";
    public static final int DB_VERSION = 1;
    private AndroidConnectionSource connectionSource;
    private static DBHelper dbHelper;

    public static DBHelper getInstance(Context context) {
        System.out.println("getInstance");
        if (dbHelper == null) {
            dbHelper = new DBHelper(context);
        }

        return dbHelper;
    }

    public DBHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
        System.out.println("DBHelper");
        File dir = new File(DB_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, DB_NAME);
        if (!file.exists()) {
            try {
                loadFile(context, file, R.raw.orm);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SQLiteDatabase db = SQLiteDatabase.openDatabase(file.getPath(), null,
                SQLiteDatabase.OPEN_READONLY);
        connectionSource = new AndroidConnectionSource(db);

    }

    /**
     * 下在文件到指定目录
     *
     * @param context
     * @param file    sd卡中的文件
     * @param id      raw中的文件id
     * @throws IOException
     */
    public static void loadFile(Context context, File file, int id)
            throws IOException {
        System.out.println("loadFile");
        InputStream is = context.getResources().openRawResource(id);
        FileOutputStream fos = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = is.read(buffer)) > 0) {
            fos.write(buffer, 0, count);
        }
        fos.flush();
        fos.close();
        is.close();
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        System.out.println("onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        System.out.println("onUpgrade");
    }

    @Override
    public <D extends Dao<T, ?>, T> D getDao(Class<T> clazz) throws SQLException {
        System.out.println("Dao");
        if (connectionSource != null) {
            return DaoManager.createDao(connectionSource, clazz);
        }
        return null;
    }
}
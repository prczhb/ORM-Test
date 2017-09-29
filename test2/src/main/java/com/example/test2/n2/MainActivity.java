package com.example.test2.n2;

import android.os.Bundle;

import com.example.test2.bean.CDG_EDUCATIONALLEVEL;
import com.example.test2.bean.PCSLPH;
import com.example.test2.R;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

import java.util.List;

public class MainActivity extends OrmLiteBaseActivity<DBHelper> {

//    DBHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        dbHelper = DBHelper.getInstance(this);
        prints(CDG_EDUCATIONALLEVEL.class);
        prints(PCSLPH.class);
        System.out.println(getLocalClassName());
    }

    private <T> void prints(Class<T> clazz) {
        try {
            Dao<T, String> dao = getHelper().getDao(clazz);
            List<T> userList = dao.queryForAll();
            for (int i = 0; i < userList.size(); i++) {
                System.out.println(userList.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getHelper() != null) {
            OpenHelperManager.releaseHelper();
            getHelper().close();
        }
    }
}

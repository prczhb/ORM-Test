package com.example.test2.n1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.test2.bean.CDG_EDUCATIONALLEVEL;
import com.example.test2.R;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = DBHelper.getInstance(this);
        try {
            Dao<CDG_EDUCATIONALLEVEL, String> dao = dbHelper.getDao(CDG_EDUCATIONALLEVEL.class);

//            CDG_EDUCATIONALLEVEL users1 = new CDG_EDUCATIONALLEVEL();

//            dao.createOrUpdate(users1);
//            Users users2 = new Users("qwe", "asd", "zxc");
//            dao.createOrUpdate(users2);
            List<CDG_EDUCATIONALLEVEL> userList = dao.queryForAll();
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
        if (dbHelper != null) {
            OpenHelperManager.releaseHelper();
            dbHelper = null;
        }
    }
}

package com.example.administrator.orm_test;

import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.orm_test.bean.CDG_EDUCATIONALLEVEL;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

public class MainActivity2 extends OrmLiteBaseActivity<DatabaseHelper> {
    private TextView mTextView;
    private RuntimeExceptionDao<CDG_EDUCATIONALLEVEL, Integer> mCDG_EDUCATIONALLEVELDAO;

    CDG_EDUCATIONALLEVEL cDG_EDUCATIONALLEVEL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_orm);
//        SqliteCodeTable sqliteCodeTable = SqliteCodeTable.getInstance(MainActivity.this);

//        getHelper().onOpen(sqliteCodeTable.openDatabase());


        mCDG_EDUCATIONALLEVELDAO = getHelper().getCDG_EDUCATIONALLEVELDataDao();

        mTextView = (TextView) findViewById(R.id.message);

        //		deleteAll();
        //
        //		mTextView.append("\n#######Begin to Insert#########\n");
        //		insertTest();
        //		display();
        //
        //		mTextView.append("\n#######Begin to Update#########\n");
        //		cDG_EDUCATIONALLEVEL.setCD_NAME("update");
        //		update(cDG_EDUCATIONALLEVEL);
        //		display();
        //
        //		mTextView.append("\n#######Begin to Delete#########\n");
        //		delete("name2");
        //		display();
        //
        //		mTextView.append("\n#######Begin to Search#########\n");
//        mTextView.setText(search("大学生").toString());

        System.out.println(this.getDatabasePath("temp"));

    }

    /**
     * 插入值测试
     */
    private void insertTest() {
        for (int i = 0; i < 5; i++) {
            cDG_EDUCATIONALLEVEL = new CDG_EDUCATIONALLEVEL();
            //			cDG_EDUCATIONALLEVEL.setCDG_EDUCATIONALLEVELname("name" + i);
            //			cDG_EDUCATIONALLEVEL.setPassword("test_pass " + i);
            mCDG_EDUCATIONALLEVELDAO.createIfNotExists(cDG_EDUCATIONALLEVEL);

        }
    }

    /**
     * 更新
     *
     * @param cDG_EDUCATIONALLEVEL 待更新的CDG_EDUCATIONALLEVEL
     */
    private void update(CDG_EDUCATIONALLEVEL cDG_EDUCATIONALLEVEL) {
        mCDG_EDUCATIONALLEVELDAO.createOrUpdate(cDG_EDUCATIONALLEVEL);
        // mCDG_EDUCATIONALLEVELDAO.update(CDG_EDUCATIONALLEVEL);
    }

    /**
     * 按照指定的id 与 CDG_EDUCATIONALLEVELname 删除一项
     *
     * @param CDG_EDUCATIONALLEVELname
     * @return 删除成功返回true ，失败返回false
     */
    private int delete(String CDG_EDUCATIONALLEVELname) {
        try {
            // 删除指定的信息，类似delete CDG_EDUCATIONALLEVEL where 'id' = id ;
            DeleteBuilder<CDG_EDUCATIONALLEVEL, Integer> deleteBuilder = mCDG_EDUCATIONALLEVELDAO.deleteBuilder();
            deleteBuilder.where().eq("CDG_EDUCATIONALLEVELname", CDG_EDUCATIONALLEVELname);

            return deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 按照id查询CDG_EDUCATIONALLEVEL
     *
     * @return
     */
    private CDG_EDUCATIONALLEVEL search(String CD_NAME) {
        try {
            // 查询的query 返回值是一个列表
            // 类似 select * from CDG_EDUCATIONALLEVEL where 'CDG_EDUCATIONALLEVELname' = CDG_EDUCATIONALLEVELname;
            List<CDG_EDUCATIONALLEVEL> CDG_EDUCATIONALLEVELs = mCDG_EDUCATIONALLEVELDAO.queryBuilder().where().eq("CD_NAME", CD_NAME).query();
            if (CDG_EDUCATIONALLEVELs.size() > 0)
                return CDG_EDUCATIONALLEVELs.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除全部
     */
    private void deleteAll() {
        mCDG_EDUCATIONALLEVELDAO.delete(queryAll());
    }

    /**
     * 查询所有的
     */
    private List<CDG_EDUCATIONALLEVEL> queryAll() {
        List<CDG_EDUCATIONALLEVEL> CDG_EDUCATIONALLEVELs = mCDG_EDUCATIONALLEVELDAO.queryForAll();
        return CDG_EDUCATIONALLEVELs;
    }

    /**
     * 显示所有的
     */
    private void display() {
        List<CDG_EDUCATIONALLEVEL> CDG_EDUCATIONALLEVELs = queryAll();
        for (CDG_EDUCATIONALLEVEL CDG_EDUCATIONALLEVEL : CDG_EDUCATIONALLEVELs) {
            mTextView.append(CDG_EDUCATIONALLEVEL.toString());
        }
    }
}

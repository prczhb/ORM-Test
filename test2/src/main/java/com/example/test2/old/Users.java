package com.example.test2.old;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2017/7/18.
 */

@DatabaseTable(tableName = "users")
public class Users {
    // id = true 必须要有.
    @DatabaseField(columnName = "ID", id = true)
    private String ID;
    @DatabaseField(columnName = "USER_NAME")
    private String USER_NAME;
    @DatabaseField(columnName = "PASSWORD")
    private String PASSWORD;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String uSER_NAME) {
        USER_NAME = uSER_NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String pASSWORD) {
        PASSWORD = pASSWORD;
    }

    public Users() {

    }

    public Users(String iD, String uSER_NAME, String pASSWORD) {
        super();
        ID = iD;
        USER_NAME = uSER_NAME;
        PASSWORD = pASSWORD;
    }

}

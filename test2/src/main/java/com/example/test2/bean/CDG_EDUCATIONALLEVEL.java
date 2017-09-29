package com.example.test2.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2017/7/18.
 */
@DatabaseTable(tableName = "CDG_EDUCATIONALLEVEL")
public class CDG_EDUCATIONALLEVEL {
    //       "-CD_ID": "10",
    //               "-CD_NAME": "研究生及以上",
    //               "-CD_AVAILABILITY": "1",
    //               "-CD_INDEX": "0"
    // 主键 id 自增长
    @DatabaseField(generatedId = true)
    private int CD_ID;

    // 映射
    @DatabaseField(canBeNull = false)
    private String CD_NAME;
    // 不为空
    @DatabaseField(canBeNull = false)
    private String CD_AVAILABILITY;

    @DatabaseField(canBeNull = false)
    private String CD_INDEX;



    public CDG_EDUCATIONALLEVEL() {
    }



    public String getCD_NAME() {
        return CD_NAME;
    }

    public void setCD_NAME(String CD_NAME) {
        this.CD_NAME = CD_NAME;
    }

    public String getCD_AVAILABILITY() {
        return CD_AVAILABILITY;
    }

    public void setCD_AVAILABILITY(String CD_AVAILABILITY) {
        this.CD_AVAILABILITY = CD_AVAILABILITY;
    }

    public String getCD_INDEX() {
        return CD_INDEX;
    }

    public void setCD_INDEX(String CD_INDEX) {
        this.CD_INDEX = CD_INDEX;
    }

    public int getCD_ID() {
        return CD_ID;
    }

    public void setCD_ID(int CD_ID) {
        this.CD_ID = CD_ID;
    }

    @Override
    public String toString() {
        return "CDG_EDUCATIONALLEVEL{" +
                ", CD_NAME='" + CD_NAME + '\'' +
                ", CD_AVAILABILITY='" + CD_AVAILABILITY + '\'' +
                ", CD_INDEX='" + CD_INDEX + '\'' +
                ", CD_ID='" + CD_ID + '\'' +
                '}';
    }
}

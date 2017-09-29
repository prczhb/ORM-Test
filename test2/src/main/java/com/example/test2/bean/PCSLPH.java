package com.example.test2.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2017/7/18.
 */
@DatabaseTable(tableName = "PCSLPH")
public class PCSLPH {

    //    JLXDM NVARCHAR2(200),
    //    LPH   NVARCHAR2(200),
    //    LPHPY VARCHAR2(255),
    //    DZBM  VARCHAR2(50) not null,
    //    JLXMC VARCHAR2(100)


    // 映射
    @DatabaseField(canBeNull = false)
    private String JLXDM;
    // 不为空
    @DatabaseField(canBeNull = false)
    private String LPH;

    @DatabaseField(canBeNull = false)
    private String LPHPY;
    @DatabaseField(canBeNull = false)
    private String DZBM;
    @DatabaseField(canBeNull = false)
    private String JLXMC;

    @Override
    public String toString() {
        return "PCSLPH{" +
                "JLXDM='" + JLXDM + '\'' +
                ", LPH='" + LPH + '\'' +
                ", LPHPY='" + LPHPY + '\'' +
                ", DZBM='" + DZBM + '\'' +
                ", JLXMC='" + JLXMC + '\'' +
                '}';
    }

    public String getJLXDM() {
        return JLXDM;
    }

    public void setJLXDM(String JLXDM) {
        this.JLXDM = JLXDM;
    }

    public String getLPH() {
        return LPH;
    }

    public void setLPH(String LPH) {
        this.LPH = LPH;
    }

    public String getLPHPY() {
        return LPHPY;
    }

    public void setLPHPY(String LPHPY) {
        this.LPHPY = LPHPY;
    }

    public String getDZBM() {
        return DZBM;
    }

    public void setDZBM(String DZBM) {
        this.DZBM = DZBM;
    }

    public String getJLXMC() {
        return JLXMC;
    }

    public void setJLXMC(String JLXMC) {
        this.JLXMC = JLXMC;
    }
}

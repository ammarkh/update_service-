package com.santechture.update_fetch_service.model;

import java.util.Date;

public class Audit {
    private int REV_ID;
    private char AUD_TYPE;
    private Date AUD_DATE;
    private long UPDATED_BITWISE;

    public int getREV_ID() {
        return REV_ID;
    }

    public void setREV_ID(int REV_ID) {
        this.REV_ID = REV_ID;
    }

    public char getAUD_TYPE() {
        return AUD_TYPE;
    }

    public void setAUD_TYPE(char AUD_TYPE) {
        this.AUD_TYPE = AUD_TYPE;
    }

    public Date getAUD_DATE() {
        return AUD_DATE;
    }

    public void setAUD_DATE(Date AUD_DATE) {
        this.AUD_DATE = AUD_DATE;
    }

    public long getUPDATED_BITWISE() {
        return UPDATED_BITWISE;
    }

    public void setUPDATED_BITWISE(long UPDATED_BITWISE) {
        this.UPDATED_BITWISE = UPDATED_BITWISE;
    }
}

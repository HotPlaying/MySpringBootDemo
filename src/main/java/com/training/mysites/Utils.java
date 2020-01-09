package com.training.mysites;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public String numstr(String s, int sum) {
        if (sum == 1) return "";
        for (int i = 0; i < sum; i++) {
            s += s;
        }
        return s;
    }

    public String itod(Integer idate) {
        if (idate==null) return "";
        Date d = new Date();
        d.setTime(idate*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }


}

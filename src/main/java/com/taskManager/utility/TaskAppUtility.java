package com.taskManager.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskAppUtility {
    public static String checkDate(Date date){
        SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
        if(date==null){
            return "not finished";
        }else{
            return df.format(date);
        }
    }

    public static String convertTime(int time){
        int hours = time/3600;
        int minutes = (time - (3600*hours))/60;
        int seconds = time%60;
        return String.format("%d h %d m %d s",hours,minutes,seconds);
    }
}

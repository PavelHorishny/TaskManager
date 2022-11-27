package test;

public class TestingTimer {
    public static String convertTime(int time){
        int hours = time/3600;
        int minutes = (time - (3600*hours))/60;
        int seconds = time%60;
        return String.format("%d h %d m %d s",hours,minutes,seconds);
    }

}

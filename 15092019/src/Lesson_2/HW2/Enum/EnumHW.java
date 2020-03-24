package Lesson_2.HW2.Enum;

public enum EnumHW {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    private int number;


    public int getNumber() {
        return number;
    }






    public int getHours(int number) {
        int hours = 0;
        hours = 40 - (number * 8);
        if(hours < 0){
            hours = 0;
        }

        return hours;
    }

}

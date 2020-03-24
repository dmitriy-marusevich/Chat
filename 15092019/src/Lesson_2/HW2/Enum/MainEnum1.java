package Lesson_2.HW2.Enum;

public class MainEnum1 {
    public static void main(String[] args) {
        EnumHW day = EnumHW.MONDAY;

        System.out.println("Now" + day + "work hour" + day.getHours(day.ordinal()));
    }
}

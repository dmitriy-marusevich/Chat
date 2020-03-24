package Lesson_2.HW2;

public class MyArrayDataException extends RuntimeException{
    int row, column;

    public MyArrayDataException(int row, int column){

        super(row + "  " + column);
        this.row = row;
        this.column = column;
    }

}

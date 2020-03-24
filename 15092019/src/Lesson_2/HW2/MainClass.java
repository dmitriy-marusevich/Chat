package Lesson_2.HW2;

import java.util.Random;

public class MainClass {
    public static int SIZE_X = 4;
    public static int SIZE_Y = 4;

    public static void main(String[] args) {
        int sum = 0;
        Random random = new Random();
        String[][] sArray = new String[SIZE_X][SIZE_Y];


        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {

                sArray[i][j] = String.valueOf(random.nextInt(50));
            }
        }
//        sArray[3][3] = "asd";
        try {
            sum = sumArray(sArray);
        }catch (MyArraySizeException e){
            e.printStackTrace();
        }catch (MyArrayDataException e){
            e.printStackTrace();
        }
        System.out.println(sum);

    }

    public static int sumArray(String[][] sArray) {
        int sum = 0;
        if (sArray.length != 4) throw new MyArraySizeException();
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < sArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(sArray[i][j]);
                } catch (MyArrayDataException e) {
                    throw new MyArrayDataException(i, j);
                }

            }

        }

        return sum;
    }
}




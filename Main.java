package com.company;

public class Main {

    public static void main(String[] args) {

        String[][] massive = new String[][]{{"123", "132", "231", "213"}, {"321", "312", "112", "121"}, {"211", "221", "222", "111"}, {"331", "332", "323", "133"}};
        try {
            try {
                int result = method(massive);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Сбавь обороты! Массив не настолько огромен!");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неверное значение!");
            System.out.println(" ");
            System.out.println("Error в ячейке: " + e.i + "x" + e.j);
        }
    }

    public static int method(String[][] mass) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (mass.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < mass.length; i++) {
            if (mass[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < mass[i].length; j++) {
                try {
                    count = count + Integer.parseInt(mass[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return count;
    }
}
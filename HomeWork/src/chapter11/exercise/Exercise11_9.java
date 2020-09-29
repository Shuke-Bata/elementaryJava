package chapter11.exercise;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise11_9 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size n: ");
        int size = input.nextInt();

        int[][] array = creat(size);
        printArray(array);
        ArrayList<Integer> rowIndex = rowFind(array);
        ArrayList<Integer> columnIndex = columnFind(array);

        System.out.print("The largest row index: ");
        for (int index : rowIndex) {
            System.out.print(index + ", ");
        }
        System.out.print("\nThe largest row index: ");
        for (int index : columnIndex) {
            System.out.print(index + ", ");
        }
        System.out.println();
    }

    public static int[][] creat(int size) {
        int[][] array = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                array[row][column] = (int)(Math.random() * 2);
            }
        }

        return array;
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public static ArrayList<Integer> rowFind(int[][] array) {
        ArrayList<Integer> rowMax = new ArrayList<>();

        rowMax.add(new Integer(0));
        int max = 0;

        for (int row = 0; row < array.length; row++) {
            int count = 0;
            for ( int column = 0; column < array[0].length; column++) {
                if (array[row][column] == 1) {
                    count++;
                }
            }

            if (count > max) {
                rowMax.clear();
                rowMax.add(new Integer(row));
            }
            else if (count == max) {
                rowMax.add(new Integer(row));
            }
        }

        return rowMax;
    }

    public static ArrayList<Integer> columnFind(int[][] array) {
        ArrayList<Integer> columnMax = new ArrayList<>();

        columnMax.add(new Integer(0));
        int max = 0;

        for (int column = 0; column < array[0].length; column++) {
            int count = 0;
            for ( int row = 0; row < array.length; row++) {
                if (array[row][column] == 1) {
                    count++;
                }
            }

            if (count > max) {
                columnMax.clear();
                columnMax.add(new Integer(column));
            }
            else if (count == max) {
                columnMax.add(new Integer(column));
            }
        }

        return columnMax;
    }

}


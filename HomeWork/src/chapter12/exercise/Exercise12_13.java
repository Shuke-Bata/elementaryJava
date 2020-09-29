package chapter12.exercise;
import java.util.Scanner;
import java.io.File;

public class Exercise12_13 {
    public static void main(String [] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Useage: file name");
        }

        int countWords = 0;
        int countLetter = 0;
        int countLine = 0;
        Scanner input = new Scanner(new File(args[0]));
        while (input.hasNextLine()) {
            String strLine = input.nextLine();
            String[] newStrLine = strLine.split(" ");
            // 使用的是 String 中的 split 先按照空格划分，在连续的空格处
            // 会出现空格为单独一行的状况
            // 所以要判断每一行是否为一个单词
            for (int i = 0; i < newStrLine.length; i++) {
                if (Character.isLetter(newStrLine[i].charAt(0))) {
                    countWords++;
                    countLetter += newStrLine[i].length();
                }
            }
            countLine++;
        }
        System.out.println("File " + args[0]);
        System.out.println(countLetter + " character");
        System.out.println(countWords + " words");
        System.out.println(countLine + " lines");

        input.close();
    }
}


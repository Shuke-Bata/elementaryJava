package chapter10.exercise;

public class Exercise10_3 {
    public static void main(String agrs[]){
        MyInteger n = new MyInteger(10);
        System.out.println(n.isPrime());
    }
}  

class MyInteger{
    private int value;

    public MyInteger(int value){
        this.value = value;
    }

    public int getMyInteger(){
        return value;
    }

    public boolean isEven(){
        return value % 2 == 0 ? true : false;
    }

    public boolean isOdd(){
        return value % 2 == 0 ? false : true;
    }

    public boolean isPrime(){
        if(value == 1) return false;

        for(int i = 2; i*i <= value; ++i){
            if(value%i == 0)
                return false;
        }
        return true;
    }

    public static boolean isEven(int num){
        return num%2 == 1 ? false : true;
    }

    public static boolean isOdd(int num){
        return num%2 == 1 ? true : false;
    }

    public static boolean isPrime(int num){
        for(int i = 2; i*i <= num; ++i)
            if(num%i == 0)
                return false;
        return num == 1 ? false : true;
    }

    public boolean equals(int num){
        return this.value == num;
    }

    public boolean equals(MyInteger num){
        return this.value == num.getMyInteger();
    }

    public static int parseInt(char[] str){
        return Integer.parseInt(str.toString());
    }

    public static int parseIne(String str){
        return Integer.parseInt(str);
    }
}

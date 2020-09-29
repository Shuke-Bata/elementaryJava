package chapter10.exercise;

import java.util.Scanner;

public class Exercise10_10 {
    @SuppressWarnings({ "unused", "resource" })
	public static void main(String agrs[]){
        Scanner cin = new Scanner(System.in);
        Queue que = new Queue();
        for(int i = 0; i < 20; ++i){
            que.enqueue(i);
        }

        int time = que.getSize();
        int index = 0;
        for(int i = 0; i < time; ++i){
            System.out.print(que.dequeue(index) + " ");
        }
        System.out.println("\n" + que.empty());
    }
}  

class Queue{
    private int[] element = null;
    private int size = 0;
    private int numberOfElement = 0;

    public Queue(){
        element = new int[8];
        numberOfElement = 8;
        size = 0;
    }

    public void enqueue(int v){
        if(numberOfElement == size){
            numberOfElement = element.length << 1;
            int[] temp = new int[numberOfElement];
            System.arraycopy(element, 0, temp, 0, element.length);
            element = temp;
        }
        element[size++] = v;
    }

    public int dequeue(int index){
        int res = element[index];
        for(int i = index, j = index+1; j < size; ++i,++j){
            element[i] = element[j];
        }
        --size;
        return res;
    }

    public boolean empty(){
        return size == 0 ? true : false;
    }

    public int getSize(){
        return size;
    }
}

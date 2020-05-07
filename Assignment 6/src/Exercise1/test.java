package Exercise1;

import java.util.Scanner;

public class test {

    public static void main(String[] args){

        int [] myArray = new int[100];
        for (int i = 0; i < 100; i++){
            myArray[i] = (int) (10000.0*Math.random());
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Please insert an index (integer value):");
        int index = input.nextInt();

        try {
            System.out.println("The element in index" + index + "is" + myArray[index]);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Index out of bounds - max = 99");
        }
    }
}

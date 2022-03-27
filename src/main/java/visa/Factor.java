package visa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Factor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        // read number from keyboard
        int number = scanner.nextInt();
        // close scanner

        System.out.println("Factors of " + number + " are:");
        // iterate from 1 till the number

        List<Integer> arrayList= new ArrayList<>();
        for (int loopCounter = 1; loopCounter <= number; loopCounter++) {
            // check if remainder of division is 0
            if (number % loopCounter == 0) {
                System.out.print(loopCounter + " ");
                arrayList.add(loopCounter);
            }
        }

        System.out.println("Enter nth Factor you want to see");
        int nthFactor = scanner.nextInt();
        if(nthFactor <=arrayList.size())
        System.out.println(arrayList.get(nthFactor-1));
        else
            System.out.println("0");

    }
}
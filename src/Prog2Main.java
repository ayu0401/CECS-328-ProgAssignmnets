import java.util.Scanner;

public class Prog2Main {
    public static void main(String[] args) {
        boolean exit = true;
        int userIn;
        System.out.println("------Heap Creation Program------");

        while(exit){
            System.out.println("--Program Options--\n1)Create Heap\n2)Input values in CSV format into heap\n" +
                    "3)Insert one element into heap\n4)Pop and element out of heap\n5)Display Sorted Heap\n" +
                    "6)Provide a length of n to generate random heap\n7)Quit\n");

            System.out.println("Enter number for the function you want to use!: ");

            Scanner sc = new Scanner(System.in);
            userIn = sc.nextInt();

            switch(userIn){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    System.out.println("Exiting Program! Thanks for using Heap Creation!");
                    exit = false;
            }
        }

    }
}

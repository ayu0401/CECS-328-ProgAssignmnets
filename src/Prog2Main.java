import java.util.Arrays;
import java.util.Scanner;

public class Prog2Main {
    public static void main(String[] args) {
        boolean exit = true;
        int userIn;
        Heap hp = null;
        System.out.println("------Heap Creation Program------");



        do {
            System.out.println("--Program Options--\n1)Create Heap\n2)Create Heap by inputting values " +
                    "in CSV format into heap\n" +
                    "3)Insert one element into heap\n4)Pop and element out of heap\n5)Display Sorted Heap\n" +
                    "6)Provide a length of n to generate random heap\n7)Quit\n");

            System.out.println("Enter number for the function you want to use!: ");

            Scanner sc = new Scanner(System.in);
            userIn = sc.nextInt();


            switch (userIn) {
                case 1:
                    System.out.println("Enter a number to set length of Heap: ");
                    int userNum = sc.nextInt();
                    hp = new Heap(userNum);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter a comma separated list of integer numbers to enter into Heap: ");
                    String userString = sc.nextLine();
                    String[] temp = userString.split(",");
                    hp = new Heap(temp.length);
                    for(int i = 0; i < temp.length; i++){
                        hp.getArray()[i] = Integer.parseInt(temp[i]);
                    }
                    Heap.BuildHeap(hp);
                    System.out.println(Arrays.toString(hp.getArray()));
                    break;
                case 3:
                    System.out.println("Enter one integer element you want to insert into Heap: ");
                    userNum = sc.nextInt();
                    assert hp != null;
                    break;

                case 4:
                    System.out.println("----Now root element from heap!----");
                    assert hp != null;
                    hp.pop(hp);
                    System.out.println(Arrays.toString(hp.getArray()));
                    break;
                case 5:

                case 6:
                case 7:
                    System.out.println("Exiting Program! Thanks for using Heap Creation!");
                    exit = false;
            }
        }while(exit);

    }
}

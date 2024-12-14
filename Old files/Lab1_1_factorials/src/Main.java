import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter a number");

        int Num = input.nextInt();
        int factorial = 1;
        for (int counter = 1; counter <= Num; counter++) {

            factorial *= counter;
            System.out.println(counter+"! ="+factorial);
        }
        input.close();
    }
}
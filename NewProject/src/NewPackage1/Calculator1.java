package NewPackage1;
import NewPackage2.Add;
import NewPackage2.Subtract;
import NewPackage2.Multiply;
import NewPackage2.Divide;

import java.util.Scanner;
/*
 * Calculator class contains main function
 */
public class Calculator1 {
    public static void main(String[] args) {
    	/*
    	 * Defining variables
    	 * Taking input from user, first no. and second no.
    	 */
        Scanner sc = new Scanner(System.in);
        double num1, num2, result = 0;
        char op;
        String history = "";
        int count = 0;

        while (true) {
            System.out.print("Enter the first number: ");
            num1 = sc.nextDouble();
            System.out.print("Enter the second number: ");
            num2 = sc.nextDouble();
            System.out.print("Enter the operator (+, -, *, /): ");
            op = sc.next().charAt(0);
            /*
             * Switch statement chooses which function to perforn on the basiis of user input
             */

            switch (op) {
                case '+':
                	/*
                	 * Creating new instance of each of the arithmetic operation classes.
                	 * calling the calculate method from them to show final result
                	 */
                    Add add = new Add(num1, num2);
                    result = add.calculate();
                    break;
                case '-':
                    Subtract sub = new Subtract(num1, num2);
                    result = sub.calculate();
                    break;
                case '*':
                    Multiply mult = new Multiply(num1, num2);
                    result = mult.calculate();
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Error: divide by zero");
                        continue;
                    }
                    Divide div = new Divide(num1, num2);
                    result = div.calculate();
                    break;
                default:
                    System.out.println("Invalid operator!");
                    continue;
            }
            //

            System.out.println("Result: " + result);
            /*
             * Adding the new calculations to String history
             * Increasing the count every time it adds a new calculation
             */
            String calculation = num1 + " " + op + " " + num2 + " = " + result + "\n";
            history = calculation + history;
            count++;
            /*
             * if statement checks that no more than 5 previous calculations are stored 
             */

            if (count >= 5) {
                int endIndex = history.lastIndexOf("\n");
                history = history.substring(0, endIndex);
            }
           

            System.out.println("History:");
            System.out.println(history);
        }
    }
}


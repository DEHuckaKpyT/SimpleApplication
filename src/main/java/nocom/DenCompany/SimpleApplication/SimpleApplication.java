package nocom.DenCompany.SimpleApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}
	Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
	String string = in.nextLine();

	int sum = 0;
	int max = 0;
	int min = 9;
        for (int i = 0; i < string.length(); i++){
		int digit = string.charAt(i) - '0';
		sum += digit;
		if (digit > max) max = digit;
		if (digit < min) min = digit;
	}

        System.out.println("Sum = " + sum);
        System.out.println("Max = " + max);
        System.out.println("Average = " + sum/string.length());
        System.out.println("Min = " + min);
}

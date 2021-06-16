package nocom.DenCompany.SimpleApplication;

import nocom.DenCompany.SimpleApplication.Actions.Action;
import nocom.DenCompany.SimpleApplication.Actions.ActionMax;
import nocom.DenCompany.SimpleApplication.Service.ActionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class SimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
		ActionService actionService = new ActionService();

		Scanner in = new Scanner(System.in);
		System.out.print("Input a number: ");
		String string = in.nextLine();

		List<Integer> digits = new ArrayList<>();
		for (int i = 0; i < string.length(); i++){
			digits.add(string.charAt(i) - '0');
		}
//		ArrayList<Action> actions = new ArrayList<>();
//		actions.add(new ActionMax());
//		actionService.setActions(new ArrayList<Action>());
		actionService.setDigits(digits);
		actionService.doAll();
	}

}


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
	}

}


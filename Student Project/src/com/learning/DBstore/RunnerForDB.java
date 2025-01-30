package com.learning.DBstore;

import java.util.Scanner;

public class RunnerForDB {
	public static void main(String[] args) {
		StudentDB store=new DBStore();
		Query q=new Query();
		
		String prompt = "> ";
		
		Scanner scanner = new Scanner(System.in);
		String line;
		System.out.print(prompt);

		while ((line = scanner.nextLine()) != null) {
			//parser.action(line);
			q.query(line);//doubt
			System.out.println(line);
			System.out.print(prompt);
		}
		
	}
	}
}

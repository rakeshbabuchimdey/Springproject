package com.learning.application;

import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import com.learning.DBstore.DBStore;
import com.learning.DBstore.Query;
import com.learning.DBstore.StudentDB;
import com.learning.model.Student;
import com.learning.parsing.StudentParser;
import com.learning.store.AutoSaveFileStore;
import com.learning.store.AutoSaveInTime;
import com.learning.store.DataBaseStore;
import com.learning.store.FileStore;
import com.learning.store.InMemoryStore;
import com.learning.store.InMemoryStoreInList;
import com.learning.store.StudentStore;

public class Runner {

	private static final Student New = null;

	public static void main(String[] args) {
		//StudentStore store = new FileStore();
		// StudentStore store = new AutoSaveFileStore();
		 //StudentStore store= new AutoSaveInTime();
		// StudentStore store1 = new InMemoryStoreInList();
		// StudentStore store= new DBStore();
		// StudentDB store=new DBStore();
		StudentStore store= new DataBaseStore();
		// this is for StudentStore
		
//		Timer time=new Timer();
//		int timelap=15000;
//		time.schedule(new AutoSaveInTime(store), timelap);
		
		
		StudentParser parser = new StudentParser(store);

		String prompt = "> ";

		Scanner scanner = new Scanner(System.in);
		String line;
		System.out.print(prompt);

		while ((line = scanner.nextLine()) != null) {
			parser.action(line);
			System.out.print(prompt);
		}

	}

	
	
	//list.iterrator
//	public static void main2(String[] args) {
//		StudentStore store = new InMemoryStoreInList();
//		// StudentStore store= new InMemoryStore();
//		StudentParser parser = new StudentParser(store);

// INSERTED DATA RANDOMLY		
//		for (int i=1;i<=10;i++) {
//			String name="abc"+i;
//			String address= i+"johns street";
//			String action=String.format("INSERT,Name:%s,Address:%s",name,address);
//			parser.action(action);
//			}
//		System.out.println("Inserted Students:");
//        Student[] students = store.selectAll();
//        for (Student student : students) {
//        	System.out.println(student);
//		}
//		

	// SAVE to file
//		store.saveToFile("students.txt");
//		System.out.println("Saved to students.txt");

//		StudentParser parser = new StudentParser(store);
//		parser.action("INSERT,Name:abc,Address:4567 johns Street");
//		parser.action("INSERT,Name:def,Address:4567 johns Street");
//		parser.action("INSERT,Name:abc2,Address:4567 johns Street");
//		parser.action("INSERT,Name:abc3,Address:4567 johns Street");
//		parser.action("INSERT,Name:abc4,Address:4567 johns Street");
//		parser.action("INSERT,Name:abc5,Address:4567 johns Street");
//		parser.action("INSERT,Name:abc6,Address:4567 johns Street");
//		parser.action("INSERT,Name:abc7,Address:4567 johns Street");
	// TODO use a for loop names: abc1 abc2, address start 3000 to 10000 -- DONE

	// TODO insted of name address || address name also should work -- DONE

	//

//		parser.action("UPDATE, ID:1, Name:abc22");

	// int count=store.getCount();
////		System.out.println(store.select(5));//printed
//		System.out.println(store.select(5));
//		//System.out.println(count);
//		store.delete(5);
//		//System.out.println();
//		System.out.println(store.count());
//		UPDATE, ID:6789, Name:abc2
	// System.out.println(store.select(2));
	// parser.action("UPDATE,ID:25,Name:xyz");
	// System.out.println(store.select(2));

	// }

//	public static void main1(String[] args) {
//		// TODO Auto-generated method stub
//		Student student1 = new Student(0, "rakesh", "praxis");
//
//		Student student3 = new Student(0, "pavan", "add3");
//		Student student4 = new Student(0, "asd", "add4s");
//		Student student5 = new Student(0, "rsd", "add5");
//		Student student6 = new Student(0, "xxxx", "add6");
//		Student student2 = new Student(0, "raj", "add2");
//		// StudentStore store= new InMemoryStore();
//		StudentStore store = new InMemoryStoreInList();
//
//		int id1 = store.insert(student1);
//		int id3 = store.insert(student3);
//		// int id3= store.select(student3);
//		int id4 = store.insert(student4);
//		int id5 = store.insert(student5);
//		int id6 = store.insert(student6);
//		int id2 = store.insert(student2);
//
////		int id7= store2.insert(student1);
////		int id8= store2.insert(student2);
////		int id9= store2.insert(student3);
//
////		store.test();
//		System.out.println(id1);
//		System.out.println(id6);
//
//		System.out.println(store.select(id6));
//		student6 = new Student(id6, "x1", "xadd");
//		store.update(student6);
//		
//		store.delete(student2.getId());
////		System.out.println(store.select(id6));
//		System.out.println(store.select(student2.getId()));
//		System.out.println(store.select(id8));

//	}

}

package com.learning.parsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.learning.model.Student;
import com.learning.store.FileStore;
import com.learning.store.StudentStore;

public class StudentParser {
	StudentStore store;

	public StudentParser(StudentStore store) {
		super();
		this.store = store;
	}

//	INSERT,Name:abc,Address:4567 johns
	public void action(String s) {
		String[] fields = s.split(",");
		// TODO the saperator should be any charactor
		if (fields[0].equals("INSERT")) {
			String[] args = fields[1].split(":");
			String name = args[1];
			args = fields[2].split(":");
			String address = args[1];
			Student std = new Student(0, name, address);
			store.insert(std);
			//store.save();
//	UPDATE,ID:6789,Name:abc2,address:12345 abcd			
		}

		if (fields[0].equals("UPDATE")) {
			// int id=0;
			String[] args = fields[1].split(":");
			int id = Integer.parseInt(args[1]);
			args = fields[2].split(":");
			String name = args[1];
			Student student = store.select(id);
			// TODO handle null if student not equal to null then go to next lines
			student.setName(name);
			store.update(student);
		}

//	DELETE,ID:6789
		if (fields[0].equals("DELETE")) {
			String[] args = fields[1].split(":");
			int id = Integer.parseInt(args[1]);
			store.delete(id);

		}
//	SELECT,ID:6789
		if (fields[0].equals("SELECT")) {
			String[] args = fields[1].split(":");
			String id = args[1];
			System.out.println(store.select(Integer.parseInt(id)));

		}
		if (fields[0].equals("COUNT")) {
			System.out.println(store.count());

		}
		if (fields[0].equals("SELECTALL")) {
			Student[] students = store.selectAll();
			if (students != null) {
				for (Student student : students) {
					System.out.println(student);
				}
			} else {
				System.out.println("No students in the List");
			}
		}
		if (fields[0].equals("SAVE")) {
			store.save();
			
			System.out.println("Students data saved as file : student.txt");
		}
	}
}

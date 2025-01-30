package com.learning.store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.learning.model.Student;

public class FileStore implements StudentStore {
	private String filePath="C:\\temp\\student.txt";
	
	public FileStore() {
		super();
		loadFromFile();
	}

	// TODO Read a file fromstudent.txt and should give output
	private StudentStore store = new InMemoryStore();

	@Override
	public void insert(Student student) {
		// TODO Auto-generated method stub
		store.insert(student);
		
	}

	@Override
	public void delete(int studentId) {
		// TODO Auto-generated method stub
		store.delete(studentId);

	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		store.update(student);
	}

	@Override
	public Student select(int studentId) {
		// TODO Auto-generated method stub
		return store.select(studentId);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return store.count();
	}

	@Override
	public Student[] selectAll() {
		// TODO Auto-generated method stub
		return store.selectAll();
	}

	private void loadFromFile() {
		// TODO Auto-generated method stub
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				int id = Integer.parseInt(data[0]);
				String name = data[1];
				String address = data[2];
				Student student = new Student(id, name, address);
				store.insert(student);
			}
			System.out.println("Student file loaded");
		} catch (IOException e) {
			System.out.println("Error loading student file: " + e.getMessage());
		}

	}

	public void save() {
		Student[] students = store.selectAll();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			String line;
			for (Student student : students) {
				System.out.println(student);
				System.out.println(student.getId());
				line = student.getId() + "," + student.getName() + "," + student.getAddress();
				writer.write(line);
				writer.newLine();
			}

			System.out.println("Student file loaded");
		} catch (IOException e) {
			System.out.println("Error loading student file: " + e.getMessage());
		}

	}

}

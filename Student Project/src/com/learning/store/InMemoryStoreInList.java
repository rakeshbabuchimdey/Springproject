package com.learning.store;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.learning.model.Student;

public class InMemoryStoreInList implements StudentStore {
	private List<Student> studentList = new ArrayList<>();

	private int counter = 0;

	public void test() {
		System.out.println("Exuting Test");
	}

	@Override
	public void insert(Student student) {
		// TODO Auto-generated method stub
		int studentId = counter++;
		student.setId(studentId);
		studentList.add(student);
		//return studentId;
	}

	@Override
	public void delete(int studentId) {
		// TODO Auto-generated method stub
		// studentList.remove(studentId);
		studentList.removeIf(student -> student.getId() == studentId);

	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == student.getId()) {
				studentList.set(i, student);
				return;
			}
		}
	}

	@Override
	public Student select(int studentId) {
		// TODO Auto-generated method stub
		for (Student student : studentList) {
			if (student.getId() == studentId) {
				return student;
			}
		}
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return studentList.size();
	}

	@Override
	public Student[] selectAll() {
		// TODO Auto-generated method stub
		Student[] studentArray = new Student[studentList.size()];
		return studentList.toArray(studentArray);
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
	}
}
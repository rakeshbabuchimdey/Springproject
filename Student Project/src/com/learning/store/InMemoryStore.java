package com.learning.store;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learning.model.Student;

public class InMemoryStore implements StudentStore {
	private Map<Integer, Student> studentMap = new HashMap();
	private int counter = 0;

	@Override
	public void insert(Student student) {
		// TODO Auto-generated method stub
		int studentId = counter++;
		student.setId(studentId);
		studentMap.put(studentId, student);
		//return studentId;
	}

	@Override
	public void delete(int studentId) {
		// TODO Auto-generated method stub
		studentMap.remove(studentId);

	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentMap.put(student.getId(), student);
		
	}

	@Override
	public Student select(int studentId) {
		// TODO Auto-generated method stub
		return studentMap.get(studentId);

	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return studentMap.size();
	}

	@Override
	public Student[] selectAll() {
		List <Student> studentList=new ArrayList(studentMap.values());
		
		
		Student[] studentArray = new Student[studentList.size()];
		return studentList.toArray(studentArray);
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

}

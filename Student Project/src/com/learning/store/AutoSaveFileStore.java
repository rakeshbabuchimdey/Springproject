package com.learning.store;

import com.learning.model.Student;

public class AutoSaveFileStore extends FileStore {

	
	public void insert(Student student) {
		// TODO Auto-generated method stub
		
		super.insert(student);
		super.save();
		//System.out.println(studentId);
		//return studentId;
	}
	@Override
	public void delete(int studentId) {
		// TODO Auto-generated method stub
		super.delete(studentId);
		super.save();
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		super.update(student);
		super.save();
	}
	
}

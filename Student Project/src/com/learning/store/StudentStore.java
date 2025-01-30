package com.learning.store;

import com.learning.model.Student;

public interface StudentStore {
	void insert(Student student);
	void delete(int studentId);
	void update(Student student);
	Student select(int studentId);
	int count();
	Student[] selectAll();
	void save();
	
	//TODO save file in textfile, 1 -- DONE
}

package com.learning.DBstore;

import com.learning.model.Student;

public interface StudentDB {
	void insert();
	void delete();
	void update();
	Student select();
	int count();
	
}

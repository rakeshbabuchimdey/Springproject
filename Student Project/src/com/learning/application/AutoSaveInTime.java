package com.learning.application;

import java.util.TimerTask;

import com.learning.model.Student;
import com.learning.store.AutoSaveFileStore;
import com.learning.store.FileStore;
import com.learning.store.InMemoryStore;
import com.learning.store.InMemoryStoreInList;
import com.learning.store.StudentStore;

public class AutoSaveInTime extends TimerTask {
	// private StudentStore store = new InMemoryStoreInList();
	// private AutoSaveFileStore store = new AutoSaveFileStore();
	private StudentStore store;

	public AutoSaveInTime(StudentStore store) {
		super();
		this.store = store;
	}

// doubt

	@Override
	public void run() {
		while (true) {
			// store.selectAll(); //HOW CAN I DO AUTO SAVE
			// store.insert();
			// store.delete();
			store.save();
			System.out.println("data saved..");
			try {
				Thread.sleep(15000);

			} catch (InterruptedException e) {
				break;
			}

		}
	}

}

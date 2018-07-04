package com.model;

import java.util.List;

import com.bean.User;

public interface Operations_Interface {
	int save(User u);
	int update(User u);
	int delete(User u);
	List<User> getAllRecords();
	User getRecordById(int id);

}

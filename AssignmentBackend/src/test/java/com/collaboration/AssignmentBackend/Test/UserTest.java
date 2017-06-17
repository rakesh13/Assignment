package com.collaboration.AssignmentBackend.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaboration.AssignmentBackend.dao.UserDao;
import com.collaboration.AssignmentBackend.model.User;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.collaboration.AssignmentBackend");
		context.refresh();
		UserDao userDAO = (UserDao) context.getBean("userDao");

		User user = (User) context.getBean("user");
		user.setUsername("ramesh");
		user.setName("ramesh");
		user.setEmail("ramesh@gmail.com");
		user.setActive(true);
		user.setPassword("password");

		userDAO.save(user);

	}

}

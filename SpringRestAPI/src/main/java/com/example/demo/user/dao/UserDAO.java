package com.example.demo.user.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.user.model.User;

@Component
public class UserDAO {

		private static List<User> userList = new ArrayList<User>();
		static int count=3;
		
		static {
			userList.add(new User(1, "Adam", new Date()));
			userList.add(new User(2, "Eve", new Date()));
			userList.add(new User(3, "Jack", new Date()));
		}
	
		
		public List<User> findAll()
		{
			return userList;
		}
		
		public void save(User user)
		{
			if(user.getId()==0)
				user.setId(++count);
			userList.add(user);
		}
		
		public User findOne(int id)
		{
			for(User u : userList)
			{
				if(u.getId()==id)
					return u;
			}
			return null;
		}
		
		public User deleteById(int id)
		{
			Iterator<User> itr = userList.iterator();
			while(itr.hasNext())
			{
				User user = itr.next();
				if(user.getId()==id)
				{
					itr.remove();
				return user;
				}
			}
			return null;
		}
}

package com.vk.todo.spring.hibernate.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {

 @Autowired
 private DataSource dataSource;
 
 @PostConstruct
 public void initialize(){
	 /* try {
   Connection connection = dataSource.getConnection();
   Statement statement = connection.createStatement();
   statement.execute("DROP TABLE IF EXISTS todos");
   statement.executeUpdate(
     "CREATE TABLE todos(" +
     "id INTEGER Primary key, " +
     "user varchar(100), " +
     "desc varchar(100) not null, " +
     "targetDate varchar(50) not null, " +
     "status varchar(30))"
     );
   statement.executeUpdate(
     "INSERT INTO todos " +
     "(user, desc, targetDate, status) " +
     "VALUES " + "('test', 'learn spring','10/10/2020','pending')"
     );
   statement.close();
   connection.close();
  }
  catch (SQLException e) {
   e.printStackTrace();
  }*/
 }
}

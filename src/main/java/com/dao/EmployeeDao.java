package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.beans.EmployeeBean;

public class EmployeeDao {
	
public static int save(EmployeeBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("insert into employee(name,email,password,address,contact,location) values(?,?,?,?,?,?)");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getPassword());
		ps.setString(4,bean.getAddress());
		ps.setString(5,bean.getContact());
		ps.setString(6,bean.getLocation());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
public static boolean validate(String email,String password){
	boolean status=false;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from employee where email=? and password=?");
		ps.setString(1,email);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
public static int update(EmployeeBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("update employee set name=?,email=?,password=?,address=?,contact=?,location=? where id=?");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getPassword());
		ps.setString(4,bean.getAddress());
		ps.setString(5,bean.getContact());
		ps.setString(6,bean.getLocation());
		ps.setInt(7,bean.getId());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}	

public static int delete(int id){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
		ps.setInt(1,id);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}

public static List<EmployeeBean> getAllRecords(){
	List<EmployeeBean> list=new ArrayList<EmployeeBean>();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from employee");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			EmployeeBean bean=new EmployeeBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setAddress(rs.getString(5));
			bean.setContact(rs.getString(6));
			bean.setLocation(rs.getString(7));
			list.add(bean);
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return list;
}

 public static EmployeeBean getRecordById(int id){
	EmployeeBean bean=new EmployeeBean();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setAddress(rs.getString(5));
			bean.setContact(rs.getString(6));
			bean.setLocation(rs.getString(7));
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return bean; 
}
}

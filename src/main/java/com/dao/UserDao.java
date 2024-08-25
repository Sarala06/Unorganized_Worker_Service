package com.dao;

import com.beans.UserBean;
import com.beans.UserBean;
import com.dao.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDao {
	
public static int save(UserBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("insert into users(name,email,gender,occupation,address,location,contact) values(?,?,?,?,?,?,?)");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getGender());
		ps.setString(4,bean.getOccupation());
		ps.setString(5,bean.getAddress());
		ps.setString(6,bean.getLocation());
		ps.setString(7,bean.getContact());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
public static int update(UserBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("update users set name=?,email=?,gender=?,occupation=?,address=?,location=?,contact=? where uid=?");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getGender());
		ps.setString(4,bean.getOccupation());
		ps.setString(5,bean.getAddress());
		ps.setString(6,bean.getLocation());
		ps.setString(7,bean.getContact());
		ps.setInt(8,bean.getUid());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}	
public static int delete(int uid){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("delete from users where uid=?");
		ps.setInt(1,uid);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
public static int deleteByName(String name){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("delete from users where name=?");
		ps.setString(1,name);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}

public static List<UserBean> getAllRecords(){
	List<UserBean> list=new ArrayList<UserBean>();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from users");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			UserBean bean=new UserBean();
			bean.setUid(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setGender(rs.getString(4));
			bean.setOccupation(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setLocation(rs.getString(7));
			bean.setContact(rs.getString(8));
			list.add(bean);
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return list;
}
public static UserBean getRecordByUid(int uid){
	UserBean bean=new UserBean();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from users where uid=?");
		ps.setInt(1,uid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			bean.setUid(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setGender(rs.getString(4));
			bean.setOccupation(rs.getString(5));         
			bean.setAddress(rs.getString(6));
			bean.setAddress(rs.getString(7));
			bean.setContact(rs.getString(8));
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return bean; 
}



}
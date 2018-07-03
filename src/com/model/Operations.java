package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Util.UtilityHelper;
import com.bean.User;

public class Operations{

	public static int save(User u) {
		int status = 0;
		Connection con =UtilityHelper.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into user(name,password,email,sex,country)values(?,?,?,?,?)");
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSex());
			ps.setString(5, u.getCountry());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e+"hi");
		}
		return status;
	}

	public static int update(User u) {
		int status = 0;
		Connection con =UtilityHelper.getConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("update user set name=?,password=?,email=?,sex=?,country=? where id=?");
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSex());
			ps.setString(5, u.getCountry());
			ps.setInt(6, u.getId());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

		return status;
	}

	public static int delete(User u) {
		int status = 0;
		Connection con =UtilityHelper.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from user where id=?");
			ps.setInt(1, u.getId());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

		return status;
	}

	public static List<User> getAllRecords() {
		List<User> list=new ArrayList<User>();
		Connection con=UtilityHelper.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from user");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setSex(rs.getString("sex"));
				u.setCountry(rs.getString("country"));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return list;
	}

	public  static User getRecordById(int id) {
		User u=null;
		Connection con=UtilityHelper.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from user where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setSex(rs.getString("sex"));
				u.setCountry(rs.getString("country"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return u;
	}

}

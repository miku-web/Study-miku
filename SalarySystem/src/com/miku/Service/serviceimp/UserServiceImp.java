package com.miku.Service.serviceimp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.miku.Entity.UserData;
import com.miku.Service.UserService;
import com.miku.Util.DBUtil;

public class UserServiceImp implements UserService{

	@Override
	public List<UserData> list() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet results = null;
		List<UserData> list = new ArrayList<UserData>();
		try {
			DBUtil util = new DBUtil();
			conn = util.getConnection();
			String sql = "select * from emp_information";
			stmt =conn.prepareStatement(sql);
			results =stmt.executeQuery();
			
			while(results.next()) {
				UserData userData = new UserData();
				userData.setUsername(results.getString("username"));
				userData.setPassword(results.getString("password"));
				userData.setName(results.getString("name"));
				userData.setSex(results.getString("sex"));
				userData.setAge(results.getInt("age"));
				userData.setDepartment(results.getString("department"));
				userData.setPosition(results.getString("position"));
				userData.setContact(results.getString("contact"));
				userData.setPermission(results.getInt("permission"));
				list.add(userData);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,stmt,results);
		}
		return list;
	}

}

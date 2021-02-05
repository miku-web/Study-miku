package com.miku.imple;

import java.sql.*;

import com.miku.DB.LoginDao;
import com.miku.Util.DBUtil;

public class LoginDaoImple implements LoginDao{

	@Override
	public int Login(String username, String password) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
			int flag = -1; 
			
			try {
				DBUtil util = new DBUtil();
				conn = util.getConnection();
				String sql ;
				sql = "select username,password from emp_information where username='"+username+"' and password='"+password+"'";
				stmt = conn.prepareStatement(sql);
				result = stmt.executeQuery();
				while(result.next()) {
					flag = 1;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(conn, stmt, result);
			}
		return flag;
	}

}

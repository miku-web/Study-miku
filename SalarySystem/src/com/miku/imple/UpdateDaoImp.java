package com.miku.imple;

import java.sql.*;

import com.miku.DB.UpdataDao;
import com.miku.Util.DBUtil;

public class UpdateDaoImp implements UpdataDao{

	@Override
	public int UpdateData(String sql) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet results = null;
		int flag = -1;
		
		try {
			DBUtil util = new DBUtil();
			conn = util.getConnection();
			stmt = conn.prepareStatement(sql);
			int upRow = stmt.executeUpdate();
			if(upRow!=0) {
				flag = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, results);
		}
		return flag;
	}

}

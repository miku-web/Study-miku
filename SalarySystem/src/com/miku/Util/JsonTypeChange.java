package com.miku.Util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class JsonTypeChange {
	public void JsonChange(HttpServletResponse response,Object obj) {
		String jsonArray = JSON.toJSONString(obj);
		try {
			PrintWriter out;
			response.setContentType("application/json;charset=UTF-8");
			out = response.getWriter();
			out.write(jsonArray);
			System.out.println(jsonArray);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("转换失败");
		}finally {
			try {
				response.getWriter().write(jsonArray);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
}

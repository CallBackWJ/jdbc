package com.douzon.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
public static void main(String[] args) {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//1. jdbc driver 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 연결하기(Connection 객체 얻어오기)
			String url="jdbc:mysql://localhost:3306/webdb?autoReconnect=true&useSSL=false";
			conn=DriverManager.getConnection(url,"webdb","webdb");
			
			//3.statement 객체를 생성
			stmt=conn.createStatement();
			
			//4. sql문 실행(꼭 세미클론 생략)
			String sql="select name,owner,birth from pet";
			rs=stmt.executeQuery(sql); //select문   
			
			//5. 결과 가져오기
			while(rs.next())
			{
				String name=rs.getString(1);
				String owner=rs.getString(2);
				String date=rs.getString(3);
				System.out.println("이름:"+name+"  오너:"+owner+"  날짜:"+ date);
				
			}
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch(SQLException e)
		{
			System.out.println("error:"+e);
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

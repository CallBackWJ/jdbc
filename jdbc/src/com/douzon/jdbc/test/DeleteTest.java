package com.douzon.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {
	public static void main(String[] args) {

		
		boolean result=delete("마음이3");
		System.out.println(result);
	}
	
	
	public static boolean delete(String name)
	{
		Connection conn=null;
		Statement stmt=null;
		boolean result=false;
		
		try {
			//1. jdbc driver 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 연결하기(Connection 객체 얻어오기)
			String url="jdbc:mysql://localhost:3306/webdb?autoReconnect=true&useSSL=false";
			conn=DriverManager.getConnection(url,"webdb","webdb");
			
			//3.statement 객체를 생성
			stmt=conn.createStatement();
			
			//4. sql문 실행(꼭 세미클론 생략)
			String sql="delete from pet where name='"+name+"'";
			int count=stmt.executeUpdate(sql); //select문   
			
			result=(count==1);
		
			//5. 결과 가져오기
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch(SQLException e)
		{
			System.out.println("error:"+e);
		}finally {
			try {
				
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}

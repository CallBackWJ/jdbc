package com.douzon.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class UpdateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean result=update("안대혁","f","마음이");
		System.out.println(result);
	}
	
	public static boolean update(String owner,String gender,String name)
	{

		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		
		try {
			//1. jdbc driver 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 연결하기(Connection 객체 얻어오기)
			String url="jdbc:mysql://localhost:3306/webdb?autoReconnect=true&useSSL=false";
			conn=DriverManager.getConnection(url,"webdb","webdb");
			
			//3.sql 준비
			String sql="update pet set owner=?,gender=? where name=?";
			pstmt=conn.prepareStatement(sql);			
			pstmt.setString(1, owner);
			pstmt.setString(2, gender);
			pstmt.setString(3, name);
			int check=pstmt.executeUpdate();
			result=(check==1);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch(SQLException e)
		{
			System.out.println("error:"+e);
		}finally {
			try {
				
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}

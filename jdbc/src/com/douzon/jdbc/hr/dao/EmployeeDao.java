package com.douzon.jdbc.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.jdbc.hr.vo.EmployeeVo;

public class EmployeeDao {
	
	
	public boolean insert(EmployeeVo employeeVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql ="insert into employee_info values(null,?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, employeeVo.getFirst_name());
			pstmt.setString(2, employeeVo.getLast_name());
			pstmt.setString(3, employeeVo.getEmail());
			pstmt.setString(4, employeeVo.getPhone());
			
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	
	
	public List<EmployeeVo> getList(){
		List<EmployeeVo> list = new ArrayList<EmployeeVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select * from employee_info order by no asc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				long no=rs.getLong(1);
				String first_name = rs.getString(2);
				String last_name = rs.getString(3);
				String email = rs.getString(4);
				String phone = rs.getString(5);
				String hire_date = rs.getString(6);
				
				EmployeeVo vo = new EmployeeVo();
				vo.setNo(no);
				vo.setFirst_name(first_name);
				vo.setLast_name(last_name);
				vo.setEmail(email);
				vo.setPhone(phone);
				vo.setHire_date(hire_date);
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}
	public List<EmployeeVo> getList(String name){
		List<EmployeeVo> list = new ArrayList<EmployeeVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select * from employee_info where concat(first_name,last_name) like '%"+name+"%' order by no asc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				long no=rs.getLong(1);
				String first_name = rs.getString(2);
				String last_name = rs.getString(3);
				String email = rs.getString(4);
				String phone = rs.getString(5);
				String hire_date = rs.getString(6);
				
				EmployeeVo vo = new EmployeeVo();
				vo.setNo(no);
				vo.setFirst_name(first_name);
				vo.setLast_name(last_name);
				vo.setEmail(email);
				vo.setPhone(phone);
				vo.setHire_date(hire_date);
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}
	
	
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/webdb?autoReconnect=true&useSSL=false";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		return conn;
	}
}

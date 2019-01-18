package com.douzon.jdbc.hr.test;

import java.util.List;

import com.douzon.jdbc.hr.dao.EmployeeDao;
import com.douzon.jdbc.hr.vo.EmployeeVo;

public class EmployeeDaoTest {

	public static void main(String[] args) {
		
		insertTest("김", "민철", "aa@aa.com", "000-0000-0000");
		insertTest("박", "성광", "aa@aa.com", "000-0000-0000");
		insertTest("김", "보미", "aa@aa.com", "000-0000-0000");
		insertTest("전", "태영", "aa@aa.com", "000-0000-0000");
		
		
		
		getListTest();
	}
	public static void insertTest(String first_name,String last_name,String email,String phone)
	{
		EmployeeVo employeeVo=new EmployeeVo();
		employeeVo.setFirst_name(first_name);
		employeeVo.setLast_name(last_name);
		employeeVo.setEmail(email);
		employeeVo.setPhone(phone);
		
		new EmployeeDao().insert(employeeVo);
	}
	public static void getListTest()
	{
		List<EmployeeVo> list=new EmployeeDao().getList();
		
		for(EmployeeVo b:list)
		{
			System.out.println(b.toString());
			
		}
	}
}

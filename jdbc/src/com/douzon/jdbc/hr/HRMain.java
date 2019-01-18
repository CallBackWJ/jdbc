package com.douzon.jdbc.hr;

import java.util.List;
import java.util.Scanner;

import com.douzon.jdbc.hr.dao.EmployeeDao;
import com.douzon.jdbc.hr.vo.EmployeeVo;

public class HRMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		while(true){
		System.out.print("사원이름을 입력하세요:");
		String name=sc.nextLine();
		if("exit".equals(name)) break;
		displayEmployeeInfo(name);
		}
		
		
	}
	private static void displayEmployeeInfo(String name) {
		List<EmployeeVo> list = new EmployeeDao().getList(name);

		for (EmployeeVo b : list) {
			System.out.println(b.toString());

		}
	}
}

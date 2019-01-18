package com.douzon.jdbc.bookshop.test;

import java.util.List;

import com.douzon.jdbc.bookshop.dao.BookDao;
import com.douzon.jdbc.bookshop.vo.BookVo;

public class BookDaoTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		insertTest("이클립스",1);
//		insertTest("뉴문",1);
//		insertTest("브레이킹던",1);
//		insertTest("트와일라잇",1);
//		
		
		
		getListTest();
	}
	
	
	public static void insertTest(String title,long authorNo)
	{
		BookVo bookVo=new BookVo();
		bookVo.setTitle(title);
		bookVo.setAuthorNo(authorNo);
		new BookDao().insert(bookVo);
	}
	
	public static void getListTest()
	{
		List<BookVo> list=new BookDao().getList();
		
		for(BookVo b:list)
		{
			System.out.println(b.toString());
			
		}
	}

}

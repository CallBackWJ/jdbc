package com.douzon.jdbc.bookshop;

import java.util.List;
import java.util.Scanner;

import com.douzon.jdbc.bookshop.dao.BookDao;
import com.douzon.jdbc.bookshop.vo.BookVo;

public class MainApp {
	public static void main(String[] args) {

		System.out.println("*****도서 정보 출력하기******");
		displayBookInfo();

		Scanner scanner = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		long no = scanner.nextInt();
		scanner.close();
		rent(no);

		System.out.println("*****도서 정보 출력하기******");
		displayBookInfo();
	}

	private static void rent(long no) {
		BookVo vo = new BookVo();
		vo.setNo(no);
		vo.setStatus("대여중");
		new BookDao().updateStatus(vo);
	}

	private static void displayBookInfo() {
		List<BookVo> list = new BookDao().getList();

		for (BookVo b : list) {
			System.out.println(b.toString());

		}
	}

}

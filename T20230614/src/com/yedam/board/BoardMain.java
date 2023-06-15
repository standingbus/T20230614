package com.yedam.board;

import java.util.List;
import java.util.Scanner;

import com.yedam.user.UserDao;

public class BoardMain {
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		UserDao uDao = new UserDao();
		BoardVO brd;
		Scanner scn = new Scanner(System.in);
		int menu = 0;
		//로그인 기능. 아이디&비번.
		// 아이디 비번이 맞으면 계속 실행
		
		
		

		while (true) {
			System.out.println("1.글등록 2.삭제 3.글내용수정 4. 글목록보기 5. 상세보기 6.종료");
			System.out.println("선택 >");
			menu = scn.nextInt();
			scn.nextLine();

			if (menu == 1) {
				
				System.out.println("제목> ");
				String title = scn.nextLine();
				System.out.println("내용> ");
				String content = scn.nextLine();
				System.out.println("작성자> ");
				String writer = scn.nextLine();

				BoardVO user = new BoardVO();

				
				user.setBrdTitle(title);
				user.setBrdContent(content);
				user.setBrdWriter(writer);

				if (dao.add(user)) {
					System.out.println("처리성공");
				} else {
					System.out.println("처리실패");
				}
			} else if (menu == 2) {
				System.out.println("번호>");
				String no = scn.nextLine();

				BoardVO user = new BoardVO();
				user.setBrdNo(no);

				if (dao.remove(user)) {
					System.out.println("삭제되었습니다.");
				} else {
					System.out.println("번호가 없습니다.");
				}
			} else if (menu == 3) {
				System.out.println("번호>");
				String no = scn.nextLine();
				System.out.println("내용>");
				String content = scn.nextLine();

				BoardVO user = new BoardVO();
				user.setBrdNo(no);
				user.setBrdContent(content);

				if (dao.modify(user)) {
					System.out.println("정상적으로 실행되었");
				} else {
					System.out.println("수정값이 없습니다.");
				}

			} else if (menu == 4) {
				List<BoardVO> list = dao.list();
				if (list.size() == 0) {
					System.out.println("조회결과 없음");
				} else {
					for (BoardVO user : list) {
						System.out.println(user.toString());
					}
				}
			} else if (menu == 5) {
				System.out.println("번호>");
				String no = scn.nextLine();

				BoardVO user = dao.search(no);
				if (user == null) {
					System.out.println("조회된 결과가 없습니다.");
				} else {
					System.out.println(user.toString());
				}
			} else if (menu == 6) {
				break;
			}
		}

	}
}

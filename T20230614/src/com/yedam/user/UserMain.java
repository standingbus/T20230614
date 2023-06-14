package com.yedam.user;

import java.util.List;
import java.util.Scanner;

public class UserMain {
	public static void main(String[] args) {

		UserDao dao = new UserDao();
		Scanner scn = new Scanner(System.in);
		int menu = 0;

		while (true) {
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.println("선택>");
			menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				System.out.println("id> ");
				String id = scn.nextLine();
				System.out.println("pw> ");
				String pw = scn.nextLine();
				System.out.println("name> ");
				String name = scn.nextLine();
				UserVO user = new UserVO();

				user.setUserId(id);
				user.setUserPw(pw);
				user.setUserName(name);

				if (dao.add(user)) {
					System.out.println("처리성공");
				} else {
					System.out.println("처리실패.");
				}
			} else if (menu == 2) {
				System.out.println("id > ");
				String id = scn.nextLine();

				UserVO user = dao.search(id);
				if (user == null) {
					System.out.println("조회된 결과가 없습니다.");
				} else {
					System.out.println(user.toString());
				}
			} else if (menu == 3) { // 수정
				System.out.println("id> ");
				String id = scn.nextLine();
				System.out.println("addr> ");
				String addr = scn.nextLine();
				System.out.println("phone> ");
				String phone = scn.nextLine();

				UserVO user = new UserVO();
				user.setUserId(id);
				user.setUserAddr(addr);
				user.setUserPhone(phone);

				if (dao.modify(user)) {
					System.out.println("정상적으로 실행이 되었습니다.");
				} else {
					System.out.println("수정값이 없습니다.");
				}
			} else if (menu == 4) {
				System.out.println("id> ");
				String id = scn.nextLine();
				UserVO user = new UserVO();
				user.setUserId(id);
				
				if(dao.remove(user)) {
					System.out.println("삭제되었습니다.");
				} else {
					System.out.println("번호가없음");
				}
			} else if (menu == 5) {
				List<UserVO> list = dao.list();
				
				if(list.size() == 0) {
					System.out.println("조회결과 없음");
				} else {
					for (UserVO user : list) {
						System.out.println(user.toString());
					}
				}
			} else if (menu == 6) {
				break;
			}
		}
		System.out.println("end of prog.");

	}
}

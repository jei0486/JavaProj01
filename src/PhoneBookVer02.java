import java.util.Scanner;

import ver02.PhoneInfo;
public class PhoneBookVer02 {
	
	public static void printMenu() {
		System.out.println("메뉴를 선택하세요");
		System.out.println("1.친구입력");
		System.out.println("2.프로그램 종료");
	}

	public static void main(String[] args) {
		
		while (true) {
			printMenu();
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			String name, phoneNumber, birthday;

			switch (choice) {
			case 1:
				System.out.println("이름:");
				name = sc.next();
				System.out.println("전화번호:");
				phoneNumber = sc.next();
				System.out.println("생일:");
				birthday = sc.next();
				
				PhoneInfo p1 = new PhoneInfo(name, phoneNumber, birthday);
				p1.showPhoneInfo();// 생년월일 입력되지않음
				break;
			case 2:
				System.exit(0);
			
			}
		}
	}
}

import java.util.Scanner;

import ver09.PhoneBookManager;



public class PhoneBookVer09 {

	public static void printMenu() {// 메뉴출력
		System.out.println("메뉴를 선택하세요");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
	}

	public static void main(String[] args) {

		PhoneBookManager phonebookmanager = new PhoneBookManager(100);

		while (true) {
			// 메뉴출력을 위한 메소드호출
			printMenu();

			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				phonebookmanager.dataInput();
				break;
			case 2:
				// 친구정보검색
				phonebookmanager.dataSearch();
				break;
			case 3:
				// 친구정보삭제
				phonebookmanager.dataDelete();
				break;
			case 4:
				// 전체정보출력
				phonebookmanager.dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}

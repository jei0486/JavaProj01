import java.util.Scanner;

import ver04.PhoneBookManager;
import ver05.NUM;

public class PhoneBookVer06 {

	public static void printMenu() {// 메뉴출력
		System.out.println("메뉴를 선택하세요");
		System.out.println("1.일반 데이터 입력");
		System.out.println("2.동창 데이터 입력");
		System.out.println("3.회사 데이터 입력");
		System.out.println("4.데이터 검색");
		System.out.println("5.데이터 삭제");
		System.out.println("6.주소록 출력");
		System.out.println("7.프로그램 종료");
		System.out.print("메뉴선택>>");
	}

	public static void main(String[] args) {

		PhoneBookManager phonebookmanager = new PhoneBookManager(100);

		
		while (true) {
			// 메뉴출력을 위한 메소드호출
			printMenu();

			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch (choice) {
			case NUM.IA: case NUM.IB: case NUM.IC:
				phonebookmanager.dataInput(choice);
				break;
			case NUM.SEARCH:
				// 친구정보검색
				phonebookmanager.dataSearch();
				break;
			case NUM.DELETE:
				// 친구정보삭제
				phonebookmanager.dataDelete();
				break;
			case NUM.PRINT:
				// 전체정보출력
				phonebookmanager.dataAllShow();
				break;
			case NUM.BYE:
				System.out.println("프로그램을 종료합니다.");
				return;// main함수의 종료는 프로그램 종료로 이어진다.
			}
		}//end of while
		
		
	}
}

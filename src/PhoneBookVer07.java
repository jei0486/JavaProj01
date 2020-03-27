import java.util.InputMismatchException;
import java.util.Scanner;

import ver07.PhoneBookManager;
import ver05.data;
import ver06.MenuSelectException;

public class PhoneBookVer07 {

	public static void printMenu() {// 메뉴출력
		System.out.println("메뉴를 선택하세요");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.print("메뉴선택>>");
	}

	public static void main(String[] args) throws MenuSelectException{

		PhoneBookManager phonebookmanager = new PhoneBookManager();

		while (true) {
			// 메뉴출력을 위한 메소드호출
			printMenu();
			
			Scanner scan = new Scanner(System.in);
			try {
			int choice = scan.nextInt();
			
			if(choice<1 || choice>5) {
				try {
					MenuSelectException mse = new MenuSelectException();
					throw mse;
				}
				catch (MenuSelectException e) {
					e.printStackTrace();
				}
			}
			switch (choice) {
			case data.IO: 
				phonebookmanager.dataInput();
				break;
			case data.SE:
				// 친구정보검색
				phonebookmanager.dataSearch();
				break;
			case data.DE:
				// 친구정보삭제
				phonebookmanager.dataDelete();
				break;
			case data.PL:
				// 전체정보출력
				phonebookmanager.dataAllShow();
				break;
			case data.BYE:
				System.out.println("프로그램을 종료합니다.");
				return;// main함수의 종료는 프로그램 종료로 이어진다.
			}
			}catch (InputMismatchException e) {
				e.printStackTrace();
			}
		}////end of while
	}////end of main
}

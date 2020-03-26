package ver06;
import java.util.Scanner;

public class PhoneBookManager {

	private PhoneInfo[] myInfo;
	private int numOfFriends;

	public PhoneBookManager(int num) {// 생성자
		myInfo = new PhoneInfo[num];
		numOfFriends = 0;
	}

	public void dataInput(int choice) {// 1.입력
		
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1.일반, 2.동창, 3.회사");
		
		Scanner scan = new Scanner(System.in);
		String name, phoneNumber,major,company;
		int grade;

		if(choice==1) {
			System.out.print("이름:");name = scan.next();
			System.out.print("전화번호:");phoneNumber = scan.next();
			PhoneInfo commonInfo = 
					new PhoneInfo(name, phoneNumber);
			myInfo[numOfFriends++] = commonInfo;
		}
		else if(choice==2) {
			System.out.print("이름:");name = scan.next();
			System.out.print("전화번호:");phoneNumber = scan.next();
			System.out.print("전공:");major=scan.next();
			System.out.print("학년:");grade=scan.nextInt();
			PhoneSchoolInfo schoolInfo = 
					new PhoneSchoolInfo(name,phoneNumber,major,grade);
			myInfo[numOfFriends++] = schoolInfo;
		}
		else if(choice==3) {
			System.out.print("이름:");name = scan.next();
			System.out.print("전화번호:");phoneNumber = scan.next();
			System.out.print("회사명:");company=scan.next();
			PhoneCompanyInfo companyInfo = 
					new PhoneCompanyInfo(name,phoneNumber,company);
			myInfo[numOfFriends++] = companyInfo;
		}
		System.out.println("친구정보 입력이 완료되었습니다.");
	}

	public void dataSearch() {// 2.검색
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();

		for (int i = 0; i < numOfFriends; i++) {
			System.out.println("검색중인이름:" + myInfo[i].name);

			// 검색할 이름과 객체의 이름이 일치하는 경우 모든정보를 출력함
			if (searchName.compareTo(myInfo[i].name) == 0) {
				myInfo[i].showPhoneInfo();
				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
			}
		}
	}//// end of dataSearch

	public void dataDelete() {// 3.삭제
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();

		int deleteIndex = -1;

		for (int i = 0; i < numOfFriends; i++) {
			if (deleteName.compareTo(myInfo[i].name) == 0) {
				myInfo[i] = null;
				deleteIndex = i;
				numOfFriends--;
			}
		}

		if (deleteIndex == -1) {
			System.out.println("==삭제된 데이터가 없습니다==");
		} else {
			for (int i = deleteIndex; i < numOfFriends; i++) {
				myInfo[i] = myInfo[i + 1];
			}
			System.out.println("==데이터(" + deleteIndex + "번)가 삭제되었습니다==");
		}
	}

	public void dataAllShow() {// 4.주소록전체출력
		for (int i = 0; i < numOfFriends; i++) {
			myInfo[i].showPhoneInfo();
		}

		System.out.println("==전체정보가 출력되었습니다==");
	}
}
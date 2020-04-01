package ver08;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {
	
	HashSet<PhoneInfo>myInfo; 
	private int numOfFriends;

	public PhoneBookManager() {// 생성자
		myInfo = new HashSet<PhoneInfo>();
	}

	public void dataInput() {// 1.입력
		
		Scanner scan = new Scanner(System.in);
		String name, phoneNumber,major,company;
		int grade;

			System.out.println("데이터 입력을 시작합니다.");
			System.out.println("1.일반, 2.동창, 3.회사");
			
			int num=scan.nextInt();
			
			switch (num) {
			case select.NOM:
				System.out.print("이름:");name = scan.next();
				
				Iterator<PhoneInfo> itr = myInfo.iterator();
				while (itr.hasNext()) {
					PhoneInfo phoneInfo = (PhoneInfo) itr.next();
					if(name.equals(phoneInfo.name)) {
						System.out.println("동일이름이 존재합니다.");
						System.out.println("덮어쓰기:(0) , 초기화면 :(1)");
						int does = scan.nextInt();
						if(does==0) {
							itr.remove();
						}
						else if(does==1) {
							return;
						}
					}
				}////while
				
				System.out.print("전화번호:");phoneNumber = scan.next();
				PhoneInfo commonInfo = 
						new PhoneInfo(name, phoneNumber);
				myInfo.add(commonInfo);

				break;
			case select.SCL:
				System.out.print("이름:");name = scan.next();
				
				
				Iterator<PhoneInfo> itr2 = myInfo.iterator();
				while (itr2.hasNext()) {
					PhoneInfo phoneInfo = (PhoneInfo) itr2.next();
					if(name.equals(phoneInfo.name)) {
						System.out.println("동일이름이 존재합니다.");
						System.out.println("덮어쓰기:(0) , 초기화면 :(1)");
						int does = scan.nextInt();
						if(does==0) {
							itr2.remove();
						}
						else if(does==1) {
							return;
						}
					}
				}////while
				
				
				System.out.print("전화번호:");phoneNumber = scan.next();
				System.out.print("전공:");major=scan.next();
				System.out.print("학년:");grade=scan.nextInt();
				PhoneSchoolInfo schoolInfo = 
						new PhoneSchoolInfo(name,phoneNumber,major,grade);
				myInfo.add(schoolInfo);

				break;
			case select.COM:
				System.out.print("이름:");name = scan.next();
				
				Iterator<PhoneInfo> itr3 = myInfo.iterator();
				while (itr3.hasNext()) {
					PhoneInfo phoneInfo = (PhoneInfo) itr3.next();
					if(name.equals(phoneInfo.name)) {
						System.out.println("동일이름이 존재합니다.");
						System.out.println("덮어쓰기:(0) , 초기화면 :(1)");
						int does = scan.nextInt();
						if(does==0) {
							itr3.remove();
						}
						else if(does==1) {
							return;
						}
					}
				}////while
				
				
				System.out.print("전화번호:");phoneNumber = scan.next();
				System.out.print("회사명:");company=scan.next();
				PhoneCompanyInfo companyInfo = 
						new PhoneCompanyInfo(name,phoneNumber,company);
				myInfo.add(companyInfo);

			}
	}//// end of dataInput

	public void dataSearch() {// 2.검색
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();

		boolean searchFlag = false;
		Iterator<PhoneInfo> itr = myInfo.iterator();
		while (itr.hasNext()) {
			PhoneInfo phoneInfo = (PhoneInfo) itr.next();
			if(searchName.equals(phoneInfo.name)) {
				searchFlag = true;
				phoneInfo.showPhoneInfo();
			}
		}
		
		if(searchFlag ==true) {
			System.out.println("요청하신 정보를 찾았습니다");
		}else {
			System.out.println("검색할 자료가 없습니다.");
		}
	}//// end of dataSearch

	public void dataDelete() {// 3.삭제
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();

		Iterator<PhoneInfo> itr = myInfo.iterator();
		while (itr.hasNext()) {
			PhoneInfo phoneInfo = (PhoneInfo) itr.next();
			if(deleteName.equals(phoneInfo.name)) {
				itr.remove();
			}
		}
	}

	public void dataAllShow() {// 4.주소록전체출력
		
		for (PhoneInfo phoneInfo : myInfo) {
			phoneInfo.showPhoneInfo();
		}
	}

	public void saveFriendInfo() {

		ObjectOutputStream out = null;

		try {
			out = new ObjectOutputStream(new FileOutputStream("src/ver08/PhoneBookManager.obj"));

			out.writeObject(myInfo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void readFriendInfo() {
		ObjectInputStream in = null;
		try {
			
			in = new ObjectInputStream(new FileInputStream("src/ver08/PhoneBookManager.obj"));
			myInfo = (HashSet<PhoneInfo>) in.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
}
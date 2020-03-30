package ver09;

import java.util.Scanner;

public class DataInput extends IBaseimpl{

	public DataInput() {
		super("kosmo", "1234");
	}
	@Override
	public void execute() {

		try { 
			String query = "INSERT INTO  phonebook_tb VALUES (?,?,?)";
			
			psmt = con.prepareStatement(query);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("이름:");
			String name = sc.nextLine();
			System.out.print("전화번호:");
			String phoneNumber = sc.nextLine();
			System.out.print("생일:");
			String birthday = sc.nextLine();
			
			psmt.setString(1, name);
			psmt.setString(2, phoneNumber);
			psmt.setString(3, birthday);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected + "행이 입력되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new DataInput().execute();
	}
}

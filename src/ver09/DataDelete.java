package ver09;

public class DataDelete extends IBaseimpl{

	@Override
	public void execute() {
		try {
			connect("kosmo", "1234");
			String query = "DELETE FROM  phonebook_tb WHERE NAME=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, scanValues("삭제할 아이디"));
			System.out.println(psmt.executeUpdate()+
					"행이 삭제되었습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		
	}
	
	public static void main(String[] args) {
		new DataDelete().execute();
	}
}

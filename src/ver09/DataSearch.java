package ver09;

public class DataSearch extends IBaseimpl{
	
	public DataSearch() {
		super("kosmo","1234");
	}
	@Override
	public void execute() {
		
		try {
			while (true) {
				String sql = "SELECT * FROM  phonebook_tb "
						+" WHERE name like '%'||?||'%'";
				psmt = con.prepareStatement(sql);
				psmt.setString(1, scanValues("찾는이름"));
				rs = psmt.executeQuery();
				while (rs.next()) {
					String name = rs.getString(1);
					String phoneNumber = rs.getString(2);
					String birthday = rs.getString(3);
					
					System.out.printf("%s %s %s \n",
							name,phoneNumber,birthday);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new DataSearch().execute();
	}

}

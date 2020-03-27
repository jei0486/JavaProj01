package ver07;

public class MenuSelectException extends Exception{
	
	public MenuSelectException() {
		super("1~5사이의 정수를 입력해주세요");
	}
}

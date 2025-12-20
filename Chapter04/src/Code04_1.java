import java.util.Scanner;
public class Code04_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String var1,var2;
		int diff;
		
		System.out.print("첫번째 문자열==>");
		var1=s.nextLine();  //nextLine()은 공백 포함 전체 문자열
		System.out.print("두번째 문자열==>");
		var2=s.nextLine();
		
		diff=var1.length()-var2.length();
		System.out.println("두 문자열의 길이의 차이는"+diff+"입니다");
		s.close();
	}

}

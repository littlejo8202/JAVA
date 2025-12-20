import java.util.Scanner;
public class Code03_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.println("학번을 입력하세요 : ");
		int stId = s.nextInt();
		
		System.out.println("이름을 입력하세요 : ");
		String name = s.next(); 
		
		System.out.println("학번 : " + stId);
		System.out.println("이름 : " + name);
		
		System.out.print("시험점수를 입력하세요 : ");
		int score = s.nextInt();
		
		if(score >= 70) {
			System.out.print("합격");
		}
		else {
			System.out.print("불합격");
		}
		s.close();
	}

}

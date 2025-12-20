import java.util.Scanner;
public class Code05_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int score;
		
		System.out.print("점수 입력==>");
		score = s.nextInt();
		
		if(score>=80)
			System.out.print("A");
		else
			if(score>=70)
				System.out.print("B");
			else
				if(score>=60)
					System.out.print("C");
				else
					System.out.print("F");
		s.close();
	}

}

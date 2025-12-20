import java.util.Scanner;
public class Code06_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int i=1;
		while(i<11) {
			int rnd = (int)(Math.random()*5+1);
			System.out.println("게임"+i+"회 : 컴퓨터가 생각한 숫자는?");
			int num = s.nextInt();
			if(num == rnd) {
				System.out.println("맞혔네요.축하합니다!!");
				break;	
			}
			System.out.println("아까워요."+rnd+"였는데요. 다시 해보세요. ㅠㅠ");
			i++;
		}
		s.close();
	}
}

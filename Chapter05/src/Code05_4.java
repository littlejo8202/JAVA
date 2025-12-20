import java.util.Scanner;
public class Code05_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.print("가위/바위/보 중에 내세요");
		String me = s.next();
			
		String[] hands = {"가위","바위","보"};
		int rnd = (int)(Math.random()*hands.length);
		String computer = hands[rnd];
		
		System.out.println("나의 가위/바위/보 ==>" + me);
		System.out.println("컴퓨터의 가위/바위/보 ==>" + computer);
		
		switch(me) {
			case "가위":
				if(computer.equals("가위")) {
					System.out.println("비겼습니다.");
				}
				else if(computer.equals("바위")) {
					System.out.println("졌습니다.");
				}
				else {
					System.out.println("이겼습니다.");
				}
				break;
			case "바위":
		
				if(computer.equals("바위")) {
					System.out.println("비겼습니다.");
				}
				else if(computer.equals("보")) {
					System.out.println("졌습니다.");
				}
				else {
					System.out.println("이겼습니다.");
				}
				break;
			case "보" :
				if(computer.equals("보")) {
					System.out.println("비겼습니다.");
				}
				else if(computer.equals("가위")) {
					System.out.println("졌습니다.");
				}
				else {
					System.out.println("이겼습니다.");
				}
				break;
			default:
				System.out.println("잘못 입력했습니다.");
			
		}
		s.close();
	}

}

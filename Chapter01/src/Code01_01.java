import java.util.Scanner;
public class Code01_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("## 택배 보내기입니다. 다음을 각각 입력하세요 ##");
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("받는 사람 :");
		String name = s.next();
		System.out.print("주소 :");
		String home = s.next();
		System.out.print("배송비 :");
		int num = s.nextInt();
		
		System.out.println("** 받는 사람 ==>" + name);
		System.out.println("** 주소 ==>" + home);
		System.out.println("** 배송비 ==>" + num);
		s.close();
	}

}

import java.util.Scanner;
public class Code01_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.print("학번 :");
		int stId = s.nextInt();
		System.out.println("학번 :" + stId);
		
		System.out.print("이름 :");
		String name = s.next();
		System.out.println("이름 :" + name);
		
		System.out.print("정수1 ==> :");
		int num1 = s.nextInt();
		
		System.out.print("정수2 ==> :");
		int num2 = s.nextInt();
		
		int Add;
		int Sub;
		int Mul;
		double Div;
		int Res;
		
		Add = num1 + num2;
		Sub = num1 - num2;
		Mul = num1 * num2;
		Div = (double) num1 / num2;
		Res = num1 % num2;
		
		System.out.println(num1 + "+" + num2 + "=" + Add);
		System.out.println(num1 + "-" + num2 + "=" + Sub);
		System.out.println(num1 + "*" + num2 + "=" + Mul);
		System.out.println(num1 + "/" + num2 + "=" + Div);
		System.out.println(num1 + "%" + num2 + "=" + Res);
	}

}

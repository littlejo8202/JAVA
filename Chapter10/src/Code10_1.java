import java.util.Scanner;

public class Code10_1 {
    static int calculate(int a, int b, String c) {
        if (c.equals("+")) return a + b;
        else if (c.equals("-")) return a - b;
        else if (c.equals("*")) return a * b;
        else if (c.equals("/")) return a / b;
        return 0; 
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String opr;
        int num1, num2;

        System.out.println("계산 입력(+,-,*,/):");
        opr = s.next();
        System.out.println("첫번째 숫자입력 :");
        num1 = s.nextInt();
        System.out.println("두번째 숫자입력 :");
        num2 = s.nextInt();
        
        int result = calculate(num1, num2, opr); 
        System.out.println("계산 결과: " + result);
        s.close();
    }
}

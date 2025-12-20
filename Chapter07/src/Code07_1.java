import java.util.Scanner;

class Rabbit{
	private int x1;
	private int y1;
	
	public void setXY(int x,int y) {
		this.x1=x;
		this.y1=y;
	}
	public int getX() {
		return this.x1;
	}
	public int getY() {
		return this.y1;
	}
}
public class Code07_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rabbit rabbit = new Rabbit();
		Scanner s =  new Scanner(System.in);
		
		while(true) {
			System.out.println("토끼가 이동할 X좌표 ==>");
			int x2 = s.nextInt();
			System.out.println("토끼가 이동할 Y좌표 ==>");
			int y2 = s.nextInt();
			rabbit.setXY(x2,y2);
			System.out.printf("**토끼의 현재 위치는 (%d,%d)입니다.\n", rabbit.getX(),rabbit.getY());
		}
	}
}

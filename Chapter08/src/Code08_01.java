import java.util.Scanner;

class Car{
	int speed;
	void accel(int x){
	}
	
}

class ScBus extends Car{
	void accel(int x) {
		if (speed+x >= 60) {
			speed = 60;
		}
		else {
			speed = speed+x;
		}
	}
}

class SpCar extends Car{
	void accel(int x) {
		speed = speed+x;
		}
}

public class Code08_01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		ScBus sb = new ScBus();
		SpCar sc = new SpCar();
		
		while(true) {
			System.out.println("가속할 속도 ==>");
			int v = s.nextInt();
			sb.accel(v);
			sc.accel(v);
			System.out.println("** 스쿨버스의 현재 속도 :" + sb.speed);
			System.out.println("** 스포츠카의 현재 속도 :" + sc.speed);
		}
	}
}

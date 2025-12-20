class Dice{
	private int dc1;
	private int dc2;
	private int dc3;
	
	public void roll() {
		this.dc1 = (int)(Math.random()*6)+1;
		this.dc2 = (int)(Math.random()*6)+1;
		this.dc3 = (int)(Math.random()*6)+1;
	}
	
	public int getDc1() { return dc1; }
    public int getDc2() { return dc2; }
    public int getDc3() { return dc3; }
}

public class Code07_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dice dice = new Dice();
		int count = 0;
		
		while (true) {
		    dice.roll();
		    count++;
		    if (dice.getDc1() == dice.getDc2() && dice.getDc1() == dice.getDc3()) {
		        break; 
		    }
		}

		System.out.printf("3개 주사위는 모두 %d입니다.\n", dice.getDc1());
		System.out.printf("같은 숫자가 나올 때까지 %d번 던졌습니다.\n", count);
		/*do {
			dice.roll();
			count++;
		} while (!(dice.getDc1()==dice.getDc2()&&dice.getDc1()==dice.getDc3()));*/
	}
}

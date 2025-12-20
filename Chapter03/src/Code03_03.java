
public class Code03_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] productName = {"캔 커피","삼각 김밥","바나나맛 우유","도시락","콜라","새우깡"};
		int [] buyPrice = {500,900,800,3500,700,1000};
		int [] sellPrice = {1800,1400,1800,4000,1500,2000};
		
		int totalIncome = 0;
		int [] buyCount = {0,10,0,5,0,0};
		int [] sellCount = {5,0,2,4,1,4};
		
		for(int i=0;i<productName.length;i++) {
			totalIncome -= buyPrice[i]*buyCount[i];
			totalIncome += sellPrice[i]*sellCount[i];
		}
		System.out.print("총 매출액은 "+totalIncome+"원입니다.");
	}
}

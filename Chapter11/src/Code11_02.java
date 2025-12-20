import java.io.BufferedReader;
import java.io.FileReader;

public class Code11_02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("C:/jdk/HelloJava/Chapter11/src/text.txt"));
		String inStr;
		
		while(true) {
			inStr=br.readLine();
			if(inStr==null)
				break;
			System.out.println(inStr);
		}
		br.close();
	}

}

import java.util.Scanner;

public class Code10_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password;
        
        while(true) {
            System.out.print("새로운 비밀번호를 입력하세요: ");
            password = sc.nextLine();
            
            if(isValidPassword(password)) {
                System.out.println("Good~ 비밀번호가 올바르게 생성되었어요.");
                break;  
            } else {
                System.out.println("오류! 비밀번호가 규칙에 맞지 않습니다.");
            }
        }
        sc.close();
    }
    
   
    public static boolean isValidPassword(String pwd) {
        
        if(pwd.length() < 8) {
            return false;
        }
        
        for(int i = 0; i < pwd.length(); i++) {
            char ch = pwd.charAt(i);
            
            if(ch >= '0' && ch <= '9') {
                return false;
            }
            
            if(!((ch >= 'A' && ch <= 'Z') || 
                 (ch >= 'a' && ch <= 'z') || 
                 (ch >= '가' && ch <= '힣'))) {
                return false;
            }
        }
        return true;
    }
}

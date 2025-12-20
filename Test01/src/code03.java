import java.util.Scanner;

class PasswordValidator {

    public boolean isValid(String pw) {
        // 규칙 만족 여부를 저장할 boolean 변수들
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // 허용되는 특수문자 목록
        String specialChars = "!@#$%";

        // 1. 길이 검사
        boolean isLengthValid = (pw.length() >= 8);

        // 2. 문자열을 순회하며(반복문) 나머지 규칙 검사 (배열 사용 금지)
        for (int i = 0; i < pw.length(); i++) {
            char ch = pw.charAt(i); // i번째 문자 가져오기

            if (Character.isUpperCase(ch)) { // 2. 대문자
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) { // 3. 소문자
                hasLower = true;
            } else if (Character.isDigit(ch)) { // 4. 숫자
                hasDigit = true;
            } else if (specialChars.indexOf(ch) != -1) { // 5. 특수문자
                // specialChars 문자열에 ch가 포함되어 있으면 true
                hasSpecial = true;
            }
        }

        // --- 결과 판정 및 오류 메시지 출력 ---
        boolean allValid = true;

        if (!isLengthValid) {
            System.out.println("→ 비밀번호는 8자 이상이어야 합니다.");
            allValid = false;
        }
        if (!hasUpper) {
            System.out.println("→ 대문자가 최소 1개 이상 포함되어야 합니다.");
            allValid = false;
        }
        if (!hasLower) {
            System.out.println("→ 소문자가 최소 1개 이상 포함되어야 합니다.");
            allValid = false;
        }
        if (!hasDigit) {
            System.out.println("→ 숫자가 최소 1개 이상 포함되어야 합니다.");
            allValid = false;
        }
        if (!hasSpecial) {
            System.out.println("→ 특수문자(!, @, #, $, %)가 최소 1개 이상 포함되어야 합니다.");
            allValid = false;
        }

        return allValid;
    }
}


  //로그인 시스템 클래스
 //ID/PW 일치 여부를 검증합니다.

class LoginSystem {
    // 검증을 위한 PasswordValidator 객체 생성
    private PasswordValidator validator = new PasswordValidator();

    // 올바른 ID와 PW (예시)
    private String correctId = "javauser";
    private String correctPw = "Java!123"; // 이 비밀번호는 모든 규칙을 만족함

    
     //로그인을 시도합니다.
     //1. 비밀번호 유효성 검사
     //2. ID/PW 일치 여부 검사
     // id 사용자가 입력한 ID
     // pw 사용자가 입력한 PW
     // true (로그인 성공), false (로그인 실패)
     
    public boolean login(String id, String pw) {
        // 1. 비밀번호 규칙 검사 
        boolean isValidFormat = validator.isValid(pw);

        // 1-1. 규칙을 통과하지 못하면 즉시 실패 반환 
        if (!isValidFormat) {
            return false;
        }

        // 2. ID/PW 일치 여부 검사 (규칙을 통과한 경우에만 실행)
        if (id.equals(correctId) && pw.equals(correctPw)) {
            // 로그인 성공
            return true;
        } else {
            // ID 또는 PW가 일치하지 않음
            System.out.println("→ 아이디 또는 비밀번호가 일치하지 않습니다.");
            return false;
        }
    }
}


  //메인 클래스: 5회 제한 로그인 로직을 구현합니다.
 
public class code03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginSystem loginSystem = new LoginSystem(); // 로그인 시스템 객체 생성

        int maxAttempts = 5; // 최대 시도 횟수
        int attempts = 0;    // 현재 시도 횟수
        boolean loggedIn = false; // 로그인 성공 여부

        // (시도 횟수 < 5) 이고 (로그인 성공 못한) 동안 반복
        while (attempts < maxAttempts && !loggedIn) {
            System.out.println("----- " + (attempts + 1) + "번째 시도 -----");
            System.out.print("아이디: ");
            String id = scanner.nextLine();
            
            System.out.print("비밀번호: ");
            String pw = scanner.nextLine();

            // 로그인 시도
            loggedIn = loginSystem.login(id, pw);
            
            attempts++; // 시도 횟수 증가

            if (loggedIn) {
                System.out.println("→ 로그인 성공!");
            } else if (attempts < maxAttempts) {
                // 실패했고, 아직 기회가 남음
                System.out.println("(남은 시도: " + (maxAttempts - attempts) + ")");
            }
        }

        // 반복문이 끝난 후, 최종 결과
        if (!loggedIn) {
            System.out.println("→ 5회 로그인 시도 실패. 프로그램을 종료합니다.");
        }

        scanner.close();
    }
}
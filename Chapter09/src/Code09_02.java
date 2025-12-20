import java.util.Scanner;

public class Code09_02 {
    public static void main(String[] args) {
        
        // 1. 사용자 입력을 받기 위한 스캐너 준비
        Scanner scanner = new Scanner(System.in);
        
        // 2. 심사위원 5명의 점수를 저장할 배열 생성 (실수형 double)
        double[] scores = new double[5];
        
        // 3. 점수 합계를 저장할 변수 초기화
        double sum = 0.0;

        System.out.println("김연아 선수 경기 끝났습니다~~짝짝짝");

        // 4. 5번 반복하며 점수 입력 받기
        for (int i = 0; i < scores.length; i++) {
            System.out.print("평가 점수==> ");
            scores[i] = scanner.nextDouble(); // 점수 입력받아 배열에 저장
            
            // 입력받은 즉시 합계에 더하기 (효율적)
            sum += scores[i]; 
        }

        // 5. 평균 계산 (총점 / 심사위원 수)
        double average = sum / scores.length;

        // 6. 결과 출력
        System.out.println("심사위원 평균 점수: " + average);
        
        scanner.close();
    }
}
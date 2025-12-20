import java.util.Scanner;

class ScoreManager {
    
    private int totalScore;      // 총점
    private int studentCount;    // 학생 수
    private int maxScore;        // 최고점
    private int minScore;        // 최저점
    private int passCount;       // 합격자 수 (60점 이상)
    private int highScorerCount; // 90점 이상 학생 수 (장학금 조건용)

    public ScoreManager() {  //변수 초기화 용 생성자
        totalScore = 0;
        studentCount = 0;
        maxScore = 0; 
        minScore = 0; 
        passCount = 0;
        highScorerCount = 0;
    }

    public void addScore(int score) {
        // 총점 및 학생 수 갱신
        totalScore += score;
        studentCount++;

        if (studentCount == 1) {
            // 첫 번째로 입력된 점수인 경우,
            // 이 점수를 초기 최댓값이자 최솟값으로 설정합니다.
            maxScore = score;
            minScore = score;
        } else {
            // 두 번째 점수부터는 기존 값과 비교하여 갱신합니다.
            // 최고점 갱신
            if (score > maxScore) {
                maxScore = score;
            }

            // 최저점 갱신
            if (score < minScore) {
                minScore = score;
            }
        }

        // 합격자 수 갱신 (합격 기준: 60점 이상으로 가정)
        if (score >= 60) {
            passCount++;
        }

        // 90점 이상 학생 수 갱신 (장학금 조건)
        if (score >= 90) {
            highScorerCount++;
        }
    }

    /**
     * 평균 점수를 반환합니다.
     * @return 평균 점수 (double)
     */
    public double getAverage() {
        // 0으로 나누는 오류 방지
        if (studentCount == 0) {
            return 0.0;
        }
        //double로 형변환
        return (double) totalScore / studentCount;
    }

    /**
     * 최고점을 반환합니다.
     * @return 최고점
     */
    public int getMax() {
        return maxScore;
    }

   
    public int getMin() {
        return minScore;
    }

    
    public int getPassCount() {
        return passCount;
    }

    
    // 장학금 대상자인지 판별합니다.
     //(조건: 평균 80점 이상이면서 90점 이상자가 1명 이상)
      //true (대상자), false (비대상자)
     
    public boolean isScholarship() {
        return getAverage() >= 80 && highScorerCount > 0;
    }

    
     //입력된 학생이 있는지 확인합니다.
    // true (학생 있음), false (학생 없음)
     
    public boolean hasStudents() {
        return studentCount > 0;
    }
}


 //메인 클래스: 프로그램을 실행하고 사용자와 상호작용합니다.
 
public class code01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScoreManager manager = new ScoreManager(); // 성적 관리 객체 생성

        System.out.print("학생 수를 입력하세요: ");
        int studentNum = scanner.nextInt();

        // 학생 수만큼 점수 입력 반복
        for (int i = 0; i < studentNum; i++) {
            System.out.print("점수를 입력하세요: ");
            int score = scanner.nextInt();
            
            // 입력받은 점수를 ScoreManager에 추가
            manager.addScore(score);
        }

        System.out.println("----- 결과 -----");

        if (manager.hasStudents()) {
            // 결과 출력
            System.out.println("최고점: " + manager.getMax());
            System.out.println("최저점: " + manager.getMin());
            // 평균은 소수점 첫째 자리까지 포맷팅
            System.out.printf("평균: %.1f\n", manager.getAverage());
            System.out.println("합격자 수: " + manager.getPassCount() + "명");

            // 장학금 대상 여부 판별
            if (manager.isScholarship()) {
                System.out.println("장학금 대상: YES");
            } else {
                System.out.println("장학금 대상: NO");
            }
        } else {
            System.out.println("입력된 학생 점수가 없습니다.");
        }

        scanner.close();
    }
}
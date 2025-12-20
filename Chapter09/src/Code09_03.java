public class Code09_03 {
    public static void main(String[] args) {
        
        int totalGames = 10000;
        
        // 1. 10000번의 경기 결과를 저장할 배열 생성
        // (값의 의미 -> 1: A승리, 2: B승리, 0: 무승부 로 약속)
        int[] results = new int[totalGames];

        // 2. 10000번 대결 진행 (Math.random 사용)
        for (int i = 0; i < totalGames; i++) {
            // 0: 가위, 1: 바위, 2: 보
            int comA = (int)(Math.random() * 3);
            int comB = (int)(Math.random() * 3);

            if (comA == comB) {
                results[i] = 0; // 무승부
            } else if ((comA == 0 && comB == 2) || // A가위 vs B보
                       (comA == 1 && comB == 0) || // A바위 vs B가위
                       (comA == 2 && comB == 1)) { // A보   vs B바위
                results[i] = 1; // A 승리
            } else {
                results[i] = 2; // B 승리
            }
        }

        // 3. 배열에 저장된 결과를 꺼내보며 카운팅
        int winA = 0;
        int winB = 0;
        int draw = 0;

        for (int i = 0; i < totalGames; i++) {
            if (results[i] == 1) {
                winA++;
            } else if (results[i] == 2) {
                winB++;
            } else {
                draw++;
            }
        }

        // 4. 결과 출력
        System.out.println(totalGames + "번 중 컴퓨터A의 승리 : " + winA);
        System.out.println(totalGames + "번 중 컴퓨터B의 승리 : " + winB);
        System.out.println(totalGames + "번 중 비긴 경기 : " + draw);
    }
}
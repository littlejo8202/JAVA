import java.util.Scanner;

class TransportCard {
    private int balance;     // 현재 잔액
    private int totalUsed;   // 총 사용 금액
    private int count;       // 총 이용 횟수

    
     //생성자: 초기 충전 금액으로 카드를 생성합니다.
     
    public TransportCard(int initialBalance) {
        this.balance = initialBalance;
        this.totalUsed = 0;
        this.count = 0;
    }

    
     //요금 정책 예시: 기본 1200원, 10km 초과 시 100원 추가
     //distance 이동 거리 (km)
     // night 심야 여부 (true/false)
     
    public void payBus(int distance, boolean night) {
        int fare = 1200; // 기본 요금
        if (distance > 10) {
            fare += 100; // 거리 추가 요금 (단순화된 규칙)
        }
        // 최종 요금 처리
        processPayment(fare, night);
    }

    
     //요금 정책 예시: 기본 1350원, 10km 초과 시 150원 추가
     //distance 이동 거리 (km)
     //심야 여부 (true/false)
     
    public void paySubway(int distance, boolean night) {
        int fare = 1350; // 기본 요금
        if (distance > 10) {
            fare += 150; // 거리 추가 요금 (단순화된 규칙)
        }
        // 최종 요금 처리
        processPayment(fare, night);
    }

    
    //(private) 실제 결제 및 상태 갱신을 처리하는 도우미 메서드
     //baseFare 기본 요금 (거리 요금 포함)
    //night 심야 여부 (true/false)
     
    private void processPayment(int baseFare, boolean night) {
        int finalFare = baseFare;

        // 심야 할증 (20%)
        if (night) {
            finalFare = (int) (finalFare * 1.2);
        }

        // 잔액 확인
        if (balance >= finalFare) {
            balance -= finalFare;
            totalUsed += finalFare;
            count++;
            System.out.println("요금 " + finalFare + "원 결제 완료.");
            System.out.println("남은 잔액: " + balance + "원");
        } else {
            System.out.println("잔액이 부족합니다. (요청: " + finalFare + "원, 잔액: " + balance + "원)");
        }
    }

    public int getTotalUsed() {
        return totalUsed;
    }

    public int getBalance() {
        return balance;
    }

   
    public int getCount() {
        return count;
    }
}


 //메인 클래스: 프로그램을 실행하고 교통카드 이용 내역을 입력받습니다.
 
public class code02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("충전 금액을 입력하세요: ");
        int initialBalance = scanner.nextInt();
        
        // 입력받은 금액으로 교통카드 객체 생성
        TransportCard card = new TransportCard(initialBalance);

        // 0(종료)이 입력될 때까지 반복
        while (true) {
            System.out.println("---------------------------------");
            System.out.print("교통수단을 선택하세요 (1:버스 2:지하철 0:종료): ");
            int transportType = scanner.nextInt();

            // 0(종료) 입력 시 반복문 탈출
            if (transportType == 0) {
                System.out.println("시스템을 종료합니다.");
                break;
            }

            System.out.print("거리(km): ");
            int distance = scanner.nextInt();

            System.out.print("심야입니까? (1:예 0:아니오): ");
            int nightInput = scanner.nextInt();
            boolean isNight = (nightInput == 1); // 1이면 true, 그 외에는 false

            // 선택된 교통수단에 따라 해당 메서드 호출
            if (transportType == 1) {
                card.payBus(distance, isNight);
            } else if (transportType == 2) {
                card.paySubway(distance, isNight);
            } else {
                System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }

        // 최종 결과 출력
        System.out.println("----- 최종 정산 -----");
        System.out.println("총 이용 금액: " + card.getTotalUsed() + "원");
        System.out.println("남은 잔액: " + card.getBalance() + "원");
        System.out.println("총 이용 횟수: " + card.getCount() + "회");

        scanner.close();
    }
}
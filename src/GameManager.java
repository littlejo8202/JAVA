import java.util.Scanner;

public class GameManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("========== [ 텍스트 RPG 전설의 시작 ] ==========");
        System.out.print("영웅의 이름을 입력하세요: ");
        String name = sc.next();
        Hero hero = new Hero(name); 
        
        // 처치한 몬스터 수 기록
        int killCount = 0; 

        // === 메인 게임 루프 ===
        while (true) {
            System.out.println("\n------------------------------------");
            System.out.println("1. 사냥터 가기  2. 내 정보 보기  3. 포션 마시기  4. 종료");
            System.out.print("선택 >> ");
            int choice = sc.nextInt();

            if (choice == 1) {
                // === 전투 시작: 몬스터 랜덤 생성 ===
                int randomSpawn = (int)(Math.random() * 3); 
                Monster monster = null;

                if (randomSpawn == 0) {
                    monster = new Monster("슬라임", 30, 3, 5); 
                } else if (randomSpawn == 1) {
                    monster = new Monster("오크", 60, 8, 10);
                } else {
                    monster = new Monster("암흑기사", 100, 15, 30); // 강한 적
                }

                System.out.println("\n!!! 야생의 " + monster.name + "이(가) 나타났다 !!!");

                // === 전투 루프 ===
                while (true) {
                    System.out.println("\n------------------------------------");
                    System.out.println(monster.name + " (HP: " + monster.currentHp + ")");
                    System.out.println(hero.name + " (HP: " + hero.currentHp + ", MP: " + hero.currentMp + ")");
                    System.out.println("------------------------------------");
                    System.out.println("[1.공격] [2.스킬] [3.포션] [4.도망]");
                    System.out.print("행동 선택 >> ");
                    int action = sc.nextInt();

                    // 1. 플레이어 턴
                    if (action == 1) {
                        hero.attack(monster);
                    } 
                    else if (action == 2) {
                        hero.showSkills();
                        System.out.print("스킬 번호 선택 >> ");
                        int skillNum = sc.nextInt();
                        int damage = hero.useSkill(skillNum - 1);
                        
                        if (damage > 0) monster.takeDamage(damage);
                        else if (damage == 0) System.out.println("스킬 사용 실패 (마나 부족)");
                        else continue; // 잘못된 번호면 턴 안 넘김
                    } 
                    else if (action == 3) {
                        hero.drinkPotion();
                    } 
                    else if (action == 4) {
                        System.out.println("무사히 도망쳤습니다!");
                        break; // 전투 루프 종료 -> 메인 메뉴로
                    }

                    // 몬스터 사망 체크
                    if (monster.currentHp <= 0) {
                        System.out.println("\n🎉 " + monster.name + "을(를) 처치했습니다!");
                        killCount++; // 킬 카운트 증가
                        System.out.println("현재까지 처치한 몬스터: " + killCount + "마리");
                        break; // 전투 루프 종료
                    }

                    // 2. 몬스터 턴 (반격)
                    System.out.println("\n🔻 몬스터의 턴!");
                    monster.attack(hero);

                    // 영웅 사망 체크 (게임 오버)
                    if (hero.currentHp <= 0) {
                        System.out.println("\n💀 비석이 세워졌습니다.. (Game Over)");
                        
                        // 결과 출력
                        System.out.println("=============================");
                        System.out.println("   [ G A M E   O V E R ]");
                        System.out.println("   용사 이름 : " + hero.name);
                        System.out.println("   처치한 몬스터 : " + killCount + "마리");
                        System.out.println("=============================");
                        
                        return; // 프로그램 전체 종료
                    }
                } 

            } else if (choice == 2) {
                hero.showStatus();
            } else if (choice == 3) {
                hero.drinkPotion();
            } else if (choice == 4) {
                System.out.println("게임을 종료합니다.");
                
                // 결과 출력
                System.out.println("=============================");
                System.out.println("   [ G A M E   R E S U L T ]");
                System.out.println("   용사 이름 : " + hero.name);
                System.out.println("   처치한 몬스터 : " + killCount + "마리");
                System.out.println("=============================");
                
                break; // 메인 루프 탈출
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        sc.close();
    }
}
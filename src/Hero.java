import java.util.ArrayList;
import java.util.Scanner;

public class Hero {
    String name;
    int maxHp, currentHp;
    int maxMp, currentMp;
    int power; // 기본 공격력
    int potionCount; // 가진 포션 개수
    
    // 배운 내용 활용 1: ArrayList (스킬 목록 관리)
    ArrayList<Skill> skillList = new ArrayList<>();

    // 생성자
    public Hero(String name) {
        this.name = name;
        this.maxHp = 100;
        this.currentHp = 100;
        this.maxMp = 50;
        this.currentMp = 50;
        this.power = 10;
        this.potionCount = 3; // 기본 포션 3개 증정

        // 기본 스킬 추가
        skillList.add(new Skill("파이어볼", 30, 10));
        skillList.add(new Skill("회심의 일격", 50, 20));
    }

    // 기능 1: 상태창 보기
    public void showStatus() {
        System.out.println("\n========== [ " + name + "의 상태 ] ==========");
        System.out.println("HP: " + currentHp + " / " + maxHp);
        System.out.println("MP: " + currentMp + " / " + maxMp);
        System.out.println("공격력: " + power);
        System.out.println("남은 포션: " + potionCount + "개");
        System.out.println("========================================");
    }
    
    // 기능 2: 일반 공격 (몬스터에게 데미지 줌)
    public void attack(Monster monster) {
        int damage = this.power;
        System.out.println(name + "의 기본 공격! " + damage + "의 데미지를 입혔습니다.");
        monster.takeDamage(damage); // 몬스터 클래스에 만들 예정
    }

    // 기능 3: 포션 마시기
    public void drinkPotion() {
        if (potionCount > 0) {
            currentHp += 30;
            if (currentHp > maxHp) currentHp = maxHp; // 최대 체력 초과 방지
            potionCount--;
            System.out.println("포션을 마셨습니다. (HP +30)");
        } else {
            System.out.println("포션이 없습니다!");
        }
    }
    // 기능 4: 스킬 목록 보여주기
    public void showSkills() {
        System.out.println("============== [ 스킬 목록 ] ==============");
        for (int i = 0; i < skillList.size(); i++) {
            Skill s = skillList.get(i); // i번째 스킬 가져오기
            // 예: 1. 파이어볼 (MP 10) - 위력: 30
            System.out.println((i + 1) + ". " + s.name + " (MP " + s.manaCost + ") - 위력: " + s.damage);
        }
        System.out.println("=========================================");
    }

    // 기능 5: 스킬 사용하기 (선택한 번호의 스킬 데미지 반환)
    public int useSkill(int index) {
        // 유효한 번호인지 확인 (ArrayList 범위 체크)
        if (index < 0 || index >= skillList.size()) {
            System.out.println("잘못된 스킬 번호입니다.");
            return -1; // 실패 의미
        }

        Skill selectedSkill = skillList.get(index);

        // 마나가 충분한지 확인
        if (currentMp >= selectedSkill.manaCost) {
            currentMp -= selectedSkill.manaCost; // 마나 차감
            System.out.println("🔥 " + name + "의 " + selectedSkill.name + " 발동!!");
            return selectedSkill.damage; // 데미지 반환
        } else {
            System.out.println("마나가 부족합니다! (현재 MP: " + currentMp + ")");
            return 0; // 데미지 없음
        }
    }
}
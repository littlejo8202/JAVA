public class Monster {
    String name;
    int maxHp, currentHp;
    int power;
    int exp; // 사냥 성공 시 줄 경험치

    public Monster(String name, int hp, int power, int exp) {
        this.name = name;
        this.maxHp = hp;
        this.currentHp = hp;
        this.power = power;
        this.exp = exp;
    }

    // 기능 1: 데미지 입기 (플레이어에게 맞았을 때)
    public void takeDamage(int damage) {
        currentHp -= damage;
        if (currentHp < 0) currentHp = 0;
        System.out.println(" ⚔️ " + name + "에게 " + damage + "의 데미지!");
        System.out.println("    (남은 체력: " + currentHp + "/" + maxHp + ")");
    }

    // 기능 2: 플레이어 공격하기
    public void attack(Hero hero) {
        System.out.println(" 👾 " + name + "의 공격! " + power + "의 데미지를 입었습니다.");
        hero.currentHp -= power; // 같은 패키지 내라 접근 가능
    }
}
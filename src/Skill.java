public class Skill {
    String name;  // 스킬 이름
    int damage;   // 공격력
    int manaCost; // 마나 소모량

    // 생성자
    public Skill(String name, int damage, int manaCost) {
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
    }
}
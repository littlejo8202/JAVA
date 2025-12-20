public class Code09_01 {
    public static void main(String[] args) {
        
        String[] quotes = {
            "시작이 반이다. - 아리스토텔레스",
            "실패는 성공의 어머니 - 에디슨",
            "중요한 것은 꺾이지 않는 마음 - 중꺾마",
            "늦었다고 생각할 때가 가장 빠르다.",
            "티끌 모아 태산."
        };

        int index = (int) (Math.random() * quotes.length);

        System.out.println("오늘의 추천 명언: " + quotes[index]);
    }
}

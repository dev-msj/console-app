package baseball;

import java.util.Arrays;
import java.util.Scanner;

public class BaseBall {
    private static int[] quiz;
    private static int[] user;

    public static void main(String[] args) {
        System.out.println("숫자야구를 시작합니다...");

        quiz = Quiz.createQuiz();

        gameStart();
    }

    private static void gameStart() {
        int strike = 0;
        while (strike != 3) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("3자리 숫자를 입력하세요...");
            System.out.print("입력 : ");
            String userInput = scanner.nextLine();

            user = Parser.parseUserInputToIntType(userInput);

            int[] hint = getGameHint();
            strike = hint[0];
            int ball = hint[1];

            System.out.printf("%d스트라이크, %d볼\n", strike, ball);
        }

        System.out.println("홈런!");
    }

    private static int[] getGameHint() {
        int[] hint = new int[]{0, 0};
        for (int i = 0; i < user.length; i++) {
            final int finalI = i;
            if (quiz[i] == user[i]) {
                hint[0]++;
            } else if(Arrays.stream(quiz).anyMatch(num -> num == user[finalI])) {
                hint[1]++;
            }
        }

        return hint;
    }
}

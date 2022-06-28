import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int[] quiz = {0, 0, 0};
    private static final int[] user = {0, 0, 0};

    public static void main(String[] args) {
        System.out.println("숫자야구를 시작합니다...");

        Random random = new Random();
        for (int i = 0; i < quiz.length; i++) {
            quiz[i] = random.nextInt(10);

            for (int j = 0; j < i; j++) {
                while (quiz[i] == quiz[j]) {
                    quiz[i] = random.nextInt(10);
                }
            }
        }

        int ball = 0;
        int strike = 0;
        while (strike != 3) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("3자리 숫자를 입력하세요...");
            System.out.print("입력 : ");
            String userInput = scanner.nextLine();

            try {
                Integer.parseInt(userInput);
            } catch (RuntimeException e) {
                throw new RuntimeException("숫자만 입력해야 합니다!\n" + e.getMessage());
            }

            if (userInput.length() != 3) {
                throw new RuntimeException("3자리를 입력해야 합니다!");
            }

            char[] charArray = userInput.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                user[i] = Character.getNumericValue(charArray[i]);
            }

            for (int i = 0; i < user.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (user[i] == user[j]) {
                        throw new RuntimeException("중복된 숫자가 존재합니다!");
                    }
                }
            }

            ball = 0;
            strike = 0;
            for (int i = 0; i < user.length; i++) {
                final int finalI = i;
                if (Arrays.stream(quiz).anyMatch(num -> num == user[finalI])) {
                    if (quiz[i] == user[i]) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }

            System.out.printf("%d스트라이크, %d볼\n", strike, ball);
        }

        System.out.println("홈런!");
    }
}

import java.util.Random;

public class Quiz {
    private static final Random random = new Random();
    private static final int[] quiz = {0, 0, 0};

    public static int[] createQuiz() {
        for (int i = 0; i < quiz.length; i++) {
            quiz[i] = random.nextInt(10);

            checkDuplicateValue(i);
        }

        return quiz;
    }

    private static void checkDuplicateValue(int i) {
        for (int j = 0; j < i; j++) {
            while (isDuplicateValue(i, j)) {
                quiz[i] = random.nextInt(10);
            }
        }
    }

    private static boolean isDuplicateValue(int i, int j) {
        return quiz[i] == quiz[j];
    }
}

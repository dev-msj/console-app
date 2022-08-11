package baseball;

public class Parser {
    private static final int[] user = {0, 0, 0};
    
    public static int[] parseUserInputToIntType(String userInput) {
        isNumericType(userInput);
        isCorrectLength(userInput);

        parseUserInputToUserGameNumber(userInput);

        isExistDuplicateValue();
        
        return user;
    }

    private static void isNumericType(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (RuntimeException e) {
            throw new RuntimeException("숫자만 입력해야 합니다!\n" + e.getMessage());
        }
    }

    private static void isCorrectLength(String userInput) {
        if (userInput.length() != 3) {
            throw new RuntimeException("3자리를 입력해야 합니다!");
        }
    }

    private static void parseUserInputToUserGameNumber(String userInput) {
        char[] charArray = userInput.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            user[i] = Character.getNumericValue(charArray[i]);
        }
    }

    private static void isExistDuplicateValue() {
        for (int i = 0; i < user.length; i++) {
            compareValueWithSmallerThanCurrentIndex(i);
        }
    }

    private static void compareValueWithSmallerThanCurrentIndex(int i) {
        for (int j = 0; j < i; j++) {
            if (isDuplicateValue(i, j)) {
                throw new RuntimeException("중복된 숫자가 존재합니다!");
            }
        }
    }

    private static boolean isDuplicateValue(int i, int j) {
        return user[i] == user[j];
    }
}

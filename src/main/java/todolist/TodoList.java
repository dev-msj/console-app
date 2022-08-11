package todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoList {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Work> workList = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("1. 목록 추가");
            System.out.println("2. 목록 보기");
            System.out.println("3. 목록 수정");
            System.out.println("4. 목록 삭제");
            System.out.println("5. 종료");

            System.out.print("작업 : ");
            int select = scanner.nextInt();

            flushScanner();

            switch (select) {
                case 1:
                    createJob();
                    break;
                case 2:
                    readJob();
                    break;
                case 3:
                    updateJob();
                    break;
                case 4:
                    deleteJob();
                    break;
                case 5:
                    System.out.println("TODO List를 종료합니다...");
                    return;
                default:
                    throw new RuntimeException("잘못된 입력입니다!");
            }

            System.out.println("\n");
        }
    }

    private static void flushScanner() {
        scanner.nextLine();
    }

    private static void createJob() {
        System.out.println("작업을 생성합니다...");
        System.out.print("작업명(최대 50자): ");
        String jobName = scanner.nextLine();

        Work newWork = new Work(jobName);
        workList.add(newWork);
    }

    private static void readJob() {
        System.out.printf("%-8s %-50s %8s\n", "작업번호", "작업명", "완료여부");

        for (int i = 0; i < workList.size(); i++) {
            Work work = workList.get(i);
            System.out.printf("%-8d " + work.toString() + "\n", i + 1);
        }
    }

    private static void updateJob() {
        System.out.println("작업을 수정합니다...");
        System.out.println("1. 작업명 변경");
        System.out.println("2. 작업 완료하기");
        System.out.print("작업 : ");
        int select = scanner.nextInt();

        flushScanner();

        if (select == 1) {
            changeJobName();
        } else if (select == 2) {
            completeJob();
        } else {
            throw new RuntimeException("잘못된 입력입니다!");
        }
    }

    private static void changeJobName() {
        readJob();

        System.out.println("작업명을 변경할 목록 번호를 입력하세요...");
        System.out.print("작업 번호 : ");
        int select = scanner.nextInt();

        flushScanner();

        try {
            Work updateWork = workList.get(select - 1);

            System.out.println("작업명(최대 50자): ");
            String updateJobName = scanner.nextLine();

            updateWork.setJobName(updateJobName);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("잘못된 번호를 입력했습니다!");
        }
    }

    private static void completeJob() {
        readJob();

        System.out.println("작업 완료여부를 수정할 목록 번호를 입력하세요...");
        System.out.print("작업 번호 : ");
        int select = scanner.nextInt();

        flushScanner();

        try {
            Work updateWork = workList.get(select - 1);

            updateWork.setCompletion(!updateWork.isCompletion());
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("잘못된 번호를 입력했습니다!");
        }
    }

    private static void deleteJob() {
        readJob();

        System.out.println("삭제할 작업을 선택하세요...");
        System.out.print("작업 번호 : ");
        int select = scanner.nextInt();

        flushScanner();

        try {
            workList.remove(select - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("잘못된 번호를 입력했습니다!");
        }
    }
}

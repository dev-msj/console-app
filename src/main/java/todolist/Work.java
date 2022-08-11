package todolist;

public class Work {
    private String jobName;
    private boolean completion;

    public Work(String jobName) {
        this.jobName = jobName;
    }

    public boolean isCompletion() {
        return completion;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setCompletion(boolean completion) {
        this.completion = completion;
    }

    @Override
    public String toString() {
        return String.format(
                "%-50s %8s",
                jobName, completionToString()
        );
    }

    private String completionToString() {
        return completion ? "O" : "X";
    }
}

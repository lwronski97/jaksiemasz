package employee;

public class Task {

    private String nameTask;
    private int workAmount;

    public Task(String nameTask, Integer timeTask) {
        this.nameTask = nameTask;
        this.workAmount = timeTask;
    }

    public String getNameTask() {
        return nameTask;
    }

    public Integer getAmountofTimeTask() {
        return workAmount;
    }

    @Override
    public String toString() {
        return "Name: " + this.nameTask + " Time: " + this.workAmount;
    }
}

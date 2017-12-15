package companyfactory;

import employee.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TaskFactory {

    private static final Random RANDOM = new Random();
    private final List<String> nameTask;

    public TaskFactory() {
        this.nameTask = Arrays.asList("fixed bug", "test", "develop soft", "refactor");
    }

    public Task randomTask() {
        return new Task(getTaskName(), RANDOM.nextInt(30) + 1);
    }

    public List<Task> randomTaskList(int size) {
        List<Task> listRandomTask = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            listRandomTask.add(randomTask());
        }
        return listRandomTask;
    }

    public String getTaskName() {
        return nameTask.get(RANDOM.nextInt(nameTask.size()));
    }
}

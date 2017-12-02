public class Task {

    private String nameTask;
    private Integer timeTask;

    public Task( String nameTask, Integer timeTask){
        this.nameTask = nameTask;
        this.timeTask = timeTask;
    }

    public String getNameTask(){
        return nameTask;
    }

    public Integer getTimeTask(){
        return timeTask;
    }

    @Override
    public String toString(){
        return "Name: " + this.nameTask + " Time: " + this.timeTask;
    }
}

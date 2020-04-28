package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Task {
    private String task;
    private int start;
    private int end;

    public Task(String task, boolean start, boolean end) {
    }

    public void setTask(String task){
        this.task = task;
    }

    public String getTask(){
        return task;
    }

    public void setStart(int start){
        this.start = start;
    }

    public int getStart(){
        return start;
    }

    public void setEnd(int end){
        this.end = end;
    }

    public int getEnd(){
        return end;
    }

    public Task(TableRow tr)
    {
        this(
                tr.getString("Task")
                , tr.getInt("Start") == 1
                , tr.getInt("End") == 5
        );
    }
}

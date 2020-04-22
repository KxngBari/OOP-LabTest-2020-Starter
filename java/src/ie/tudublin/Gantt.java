package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;

public class Gantt extends PApplet
{
	ArrayList<Task> tasks = new ArrayList<Task>();

	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");
		for(TableRow row:table.rows())
		{
			Task task = new Task(row);
			tasks.add(task);
		}
	}

	public void printTasks()
	{
        for(Task task:tasks)
        {
            println(task);
        }
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	public void displayTasks(){
        float border = width * 0.05f;
        float x;
        float y;
        background(0);
        colorMode(HSB);
        stroke(0, 0, 255);
        textAlign(CENTER, CENTER);
        for(int i = 1 ; i <= 30 ; i ++)
        {
            x = map(i, 0, 30, border, width - border);
            line(x, border, x, height - border);

            fill(255);
            text(i, x, border / 2);
        }

        for(int i=0; i<tasks.size();i++){
        	Task horiheader = tasks.get(i);
			y = map(tasks.get(i).start, 0, 30, border, height - border);
			text(horiheader.getTask(), border / 2, y);
		}
    }

	public void setup(){
		loadTasks();
		printTasks();
		displayTasks();
	}
}

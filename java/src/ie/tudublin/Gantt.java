package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;

public class Gantt extends PApplet
{
	ArrayList<Task> tasks = new ArrayList<Task>();
	private float leftSide;
	private float margin;

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
		int days = 30;
        float x, y;
        background(0);
        colorMode(HSB);
        stroke(255);
        textAlign(CENTER, CENTER);

        for(int i = 1 ; i <= days ; i ++)
        {
            x = map(i, 1, 30, leftSide, width - margin);
            line(x, margin, x, height - margin);
            text(i, x, margin * 0.5f);
        }

        for(int i=0; i<tasks.size();i++){
			fill(255);
        	Task horiheader = tasks.get(i);
			y = map(tasks.get(i).start, 0, 25, border, height - border);
			text(horiheader.getTask(), border / 2, y);

			rect(60, 50, 20, 45);

		}
    }

	public void setup(){
		loadTasks();
		printTasks();
	}

	public void draw(){
		displayTasks();
	}
}

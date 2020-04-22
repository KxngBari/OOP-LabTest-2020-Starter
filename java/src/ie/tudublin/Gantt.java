package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;

public class Gantt extends PApplet
{
	public ArrayList<Task> tasks = new ArrayList<Task>();
	private float leftSide = 65;
	private float gap = 30;

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
		int monthdays = 30;
        float x, y;
        float newcolour;
        background(0);
        colorMode(HSB);
        stroke(255);
        textAlign(CENTER);
        fill(255);

        for(int i = 1; i <= monthdays ; i++)
        {
            x = map(i, 0, monthdays, leftSide, width - leftSide);
            text(i, x, gap);
            line(x, gap*2, x, height - leftSide);
        }

        for(int i=0;i<tasks.size(); i++)
		{
			fill(255);
			y = map(i,0,tasks.size(), 2*gap, height - gap);
			text(tasks.get(i).getTask(), gap, y);

			noStroke();
			newcolour = map(i,0,tasks.size(),0,255);
			fill(newcolour,255,255);

			float Begin = map(tasks.get(i).getStart(), 1, monthdays, 90, width - leftSide);
			float End = map(tasks.get(i).getEnd(), i, monthdays, 95, width - leftSide);
			rect(Begin, y + 10, End - Begin, 20, 10);

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

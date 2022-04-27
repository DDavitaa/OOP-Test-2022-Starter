package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();
	int selectedNematode = 0;
	float border;

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
			if(selectedNematode != 0)
			{
				selectedNematode--;
			}

			
		}		
		if (keyCode == RIGHT)
		{
			if(selectedNematode != nematodes.size())
			{
				selectedNematode++;
			}
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();
		border = width * 0.1f;

		drawNematode();
		
		
	}
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv","header");

		for(TableRow r:table.rows())
		{
			Nematode n = new Nematode(r);
			nematodes.add(n);
		}
	}

	public void drawNematode()
	{
		for(Nematode n: nematodes)
		{
			n.render(this);
		}
	}


	public void draw()
	{	
		stroke(255);
		noFill();
		strokeWeight(3);

		//Left Line
		line(100,400,200,400);
		line(100,400,130,370);
		line(100,400,130,430);

		//Right Line
		line(700,400,600,400);
		line(700,400,670,370);
		line(700,400,670,430);

		
		drawNematode();

	}
}

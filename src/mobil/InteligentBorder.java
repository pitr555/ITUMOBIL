 
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.border.*;

public class InteligentBorder extends AbstractBorder
{
  

	static int part = 0;
	static int parts = 2;
 

    public void paintBorder(Component c, Graphics g, int x, int y,
                            int w, int h)
    {
 
    	Graphics2D g2 = (Graphics2D) g; 
    	//g2.setColor(Color.WHITE);
    	g2.setStroke(new BasicStroke(5.8f));
    	
    	
    	int b_w = w - 1;
    	int b_h = h - 1;
    	
    	
    	// body v rohoch elementu
    	PointE p = new PointE(x, y, x, y, b_w, b_h);
    	PointE p2 = new PointE(x + b_w, y, x, y, b_w, b_h);
    	PointE p3 = new PointE(x + b_w, y + b_h, x, y, b_w,b_h);
    	PointE p4 = new PointE(x, y + b_h, x, y, b_w, b_h);
    	PointE p5 = new PointE(x, y + 1, x, y, b_w, b_h);

    	// prvy a posledny bod vykreslovaneho mnohouholnika
    	PointE first = PointE.getFirst(part, parts, x, y, b_w, b_h);
    	PointE last = PointE.getLast(part, parts, x, y, b_w, b_h);

        
    	int [] xPoints  = new int[7];
    	int [] yPoints = new int[7];
    	
		ArrayList<PointE> al = new ArrayList<PointE>();
		
		al.add(p);
		al.add(p4);		
		al.add(p3);
		al.add(p2);		
		al.add(p5);
		al.add(first);
		al.add(last);
		
   		Collections.sort(al); 		
 
    	int num = 0;
    	for (int i = 0;i < al.size(); i++)
    	{
    		if (al.get(i).compareTo(first) < 0)
    		{
    			continue;
    		}
    		
    		if (al.get(i).compareTo(last) > 0)
    		{
    			break;
    		}
    		
    		xPoints[num] = al.get(i).x;
    		yPoints[num] = al.get(i).y;
    		num++;
    	}
    	

        g2.drawPolyline(xPoints, yPoints,num  );
       
 
    }


}
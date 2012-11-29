import java.awt.Point;


public class PointE extends Point implements Comparable<PointE>{
	
	int edge = -1; // zatial ziadna
	
	public PointE(int x, int y,int b_x, int b_y,int b_w, int b_h )
	{
		this.x = x;
		this.y = y;
		
		if (x != b_w && y == b_y)
		{
			edge = 0; // vrchna hrana
		}
		else if (x == b_w && y != b_h)
		{
			edge = 1; // prava hrana
		}
		
		else if (x != b_x && y == b_h)
		{
			edge = 2; // spodna hrana
		}	
		
		else
		{
			edge = 3; // lava hrana
		}
		
	}

	@Override
	public int compareTo(PointE p) {
		if (this.edge > p.edge)
		{			
			return 1;
		}
		else if (this.edge < p.edge)
		{
			return -1;
		}
		else // su na rovnakej hrane
		{
			if (edge == 0)
			{
				return Integer.valueOf(x).compareTo(p.x);
			}
			else if (edge == 1)
			{
				return Integer.valueOf(y).compareTo(p.y);
			}
			else if (edge == 2)
			{
				return -(Integer.valueOf(x).compareTo(p.x));
			}
			else 
			{
				return -(Integer.valueOf(y).compareTo(p.y));
			}
			
		}

		
	}

	
	
	static PointE getFirst(int part, int parts,int b_x, int b_y, int b_w, int b_h )
	{
		int circum = 2 * (b_w + b_h);
		int part_length = circum / parts;
		int begin = part * part_length;
		
		
		if (begin < b_w)
		{
			return new PointE(begin, b_y, b_x, b_y, b_w, b_h);
		}
		else if(begin < b_w + b_h)
		{
			return new PointE(b_w, begin - b_w, b_x, b_y, b_w, b_h);
		}
		else if(begin < 2 * b_w + b_h)
		{
			return new PointE(b_w - (begin - b_w - b_h), b_h, b_x, b_y, b_w, b_h);
		}
		else
		{
			return new PointE(b_x, b_h - (begin - 2 * b_w - b_h), b_x, b_y, b_w, b_h);
		}

	}
	
	static PointE getLast(int part, int parts,int b_x, int b_y, int b_w, int b_h )
	{
		int circum = 2 * (b_w + b_h);
		int part_length = circum / parts;
		int end = (part + 1) * part_length;
			
		
		if (end < b_w)
		{
			return new PointE(end, b_y, b_x, b_y, b_w, b_h);
		}
		else if(end < b_w + b_h)
		{
			return new PointE(b_w, end - b_w, b_x, b_y, b_w, b_h);
		}
		else if(end < 2 * b_w + b_h)
		{
			return new PointE(b_w - (end - b_w - b_h), b_h, b_x, b_y, b_w, b_h);
		}
		else if (end < 2 * (b_w + b_h) && part + 1 != parts)
		{
			return new PointE(b_x, b_h - (end - 2 * b_w - b_h), b_x, b_y, b_w, b_h);
		}
		else
		{
			return new PointE(b_x, b_y + 1, b_x, b_y, b_w, b_h);
		}

	}	
}

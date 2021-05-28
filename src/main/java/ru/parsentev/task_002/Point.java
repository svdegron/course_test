package ru.parsentev.task_002;

//import org.slf4j.Logger;

//import static org.slf4j.LoggerFactory.getLogger;

/**
 * Class Point defines a point in coordination system (x, y).
 * 
 * @author parsentev
 * @since 19.07.2016
 */
public class Point {
	
//	private static final Logger log = getLogger(Point.class);

	private final int x;
	private final int y;

	public Point(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public double distanceTo(final Point point) {
		
		// If I remember distance between two point calculated by formula
		// sqrt ( (x1^2 + x2^2) - (y1^2 + y2^2) )
		// now, let's ask google
		// I wrong, formula is
		// sqrt ( (x1 - x2)^2 + (y1 - y2)^2 )
		
		double distance = Math.sqrt( (this.x - point.x) * (this.x - point.x) + (this.y - point.y) * (this.y - point.y) );
		// or
		// double distance = Math.sqrt( Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2) );
		
		return distance;
	}
}

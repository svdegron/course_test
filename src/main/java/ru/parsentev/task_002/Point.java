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

		double distance = Math.sqrt((this.x - point.x) * (this.x - point.x) + (this.y - point.y) * (this.y - point.y));
		// or
		// double distance = Math.sqrt( Math.pow(this.x - point.x, 2) + Math.pow(this.y
		// - point.y, 2) );
		
		// at solution added function «abs»

		return distance;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	// I know it was very simple to be true → google → I knew it was too easy to be
	// true
	// need toString / equals and hash code, how I could forget
	// mouse right button → Source…

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
		// at solution: return String.format("(%s, %s)", this.x, this.y);
		// it just format. Maybe looks better… I don't want repeat «solution»
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;

		// and this I think need changes. But I not know why… yet
		// int result = x;
		// result = 31 * result + y;
		// return result;
	}

	// at solution more compact. Return true or false in one line with if
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}

package ru.parsentev.task_003;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_002.Point;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Triangle {

	private static final Logger log = getLogger(Triangle.class);

	protected final Point first;
	protected final Point second;
	protected final Point third;

	public Triangle(final Point first, final Point second, final Point third) {

		this.first = first;
		this.second = second;
		this.third = third;

	}

	public boolean exists() {

		// if determinant equals 0 then all point have on one straight line…
		// …or situated in one point

		if (secondOrderDeterminant() == 0) {
			return false;
		} else {
			return true;
		}

	}

	public double area() {

		// inLine / inPoint → throw exception

		// 1 | A B |
		// — | | = (A * D + C * B) / 2 → must be > 0
		// 2 | C D |

		double result = Math.abs(secondOrderDeterminant()) / 2;

		if (result == 0) {
			throw new IllegalStateException("Triangle don't exist");
		} else {
			return result;
		}

	}

	@Override
	public String toString() {
		return "Triangle ABC [(" + first + "), (" + second + "), (" + third + ")]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		result = prime * result + ((third == null) ? 0 : third.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		if (third == null) {
			if (other.third != null)
				return false;
		} else if (!third.equals(other.third))
			return false;
		return true;
	}

	private int secondOrderDeterminant() {

		// determinant
		// | a11 a12 |
		// | a21 a22 | = (a11 * a22 + a12 * a21)

		// added getters at class «Point» from second task
		int a11 = first.getX() - third.getX();
		int a12 = first.getY() - third.getY();
		int a21 = second.getX() - third.getX();
		int a22 = second.getY() - third.getY();

		int mainDiagonal = a11 * a22;
		int sideDiagonal = a12 * a21;

		int result = mainDiagonal + sideDiagonal;

		return result;

	}

}



public class Coordinate {

	private double x;

	private double y;

	public Coordinate() {
	}

	public Coordinate(double x, double y) {
		setX(x);
		setY(y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		Coordinate c = (Coordinate) obj;

		return (Math.abs(c.getX() - this.getX()) < TestGrahanScan.EPSILON)
				&& (Math.abs(c.getY() - this.getY()) < TestGrahanScan.EPSILON);
	}
}

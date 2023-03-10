public class Triangle extends GeometricObject
{
    private double side1, side2, side3;
    
    public Triangle() {
    	this.side1 = 1;
    	this.side2 = 1;
    	this.side3 = 1;
    }

	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public double getArea() {
		double semi_perimeter = this.getPerimeter() / 2;
		double area = Math.sqrt(semi_perimeter * (semi_perimeter - side1) * (semi_perimeter - side2) * (semi_perimeter - side3));
		return area;
	}
	
	public double getPerimeter() {
		double perimeter = side1 + side2 + side3;
		return perimeter;
	}
	
	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

	@Override
	public String toString() {
		return "Side1 : " + side1 + "\nSide2 : " + side2 + "\nSide3 : " + side3 + "\nPerimeter : " + this.getPerimeter()
		+ "\nArea : " + this.getArea() + "\n";
	}
    
	public static void main(String[]args) {
		Triangle t1 = new Triangle();
		Triangle t2 = new Triangle(3, 4, 5);
		System.out.println(t1);
		System.out.println(t2);
	}
}

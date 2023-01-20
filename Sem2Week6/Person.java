public class Person implements Measurable
{
    double height;
    String name;
    
	public Person(double height, String name) {
		this.name = name;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getMeasure() {
		return height;
	}
    
	@Override
	public String toString() {
		return name;
	}
}

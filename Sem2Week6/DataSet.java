public class DataSet
{
	private double sum;
	private Measurable maximum;
	private Measurable minimum;
	private int count;
 
	public void add(Measurable x)
	{
		sum = sum + x.getMeasure();
		if (count == 0 || maximum.getMeasure() < x.getMeasure())
			maximum = x;
		if(count == 0 || minimum.getMeasure() > x.getMeasure())
			minimum = x;
		count++;
	}
	public double getAverage()
	{
		return sum/count;
	}
	public Measurable getMaximum()
	{
		return maximum;
	}
	public Measurable getMinimum() {
		return minimum;
	}
}

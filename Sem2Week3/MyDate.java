import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class MyDate
{
    private long year, month, day;
    
    public MyDate(){
    	LocalDate today = LocalDate.now();
    	this.year = today.getYear();
    	this.month = today.getMonthValue();
    	this.day = today.getDayOfMonth();
    }
    
    public MyDate(long elapsedTime) {
    	LocalDate date = LocalDate.ofEpochDay(TimeUnit.MILLISECONDS.toDays(elapsedTime));
    	this.year = date.getYear();
    	this.month = date.getMonthValue();
    	this.day = date.getDayOfMonth();
    }
    
    public MyDate(long year, long month, long day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	public long getMonth() {
		return month;
	}

	public void setMonth(long month) {
		this.month = month;
	}

	public long getDay() {
		return day;
	}

	public void setDay(long day) {
		this.day = day;
	}
	
	public void setDate(long elapsedTime) {
    	LocalDate date = LocalDate.ofEpochDay(TimeUnit.MILLISECONDS.toDays(elapsedTime));
    	this.year = date.getYear();
    	this.month = date.getMonthValue();
    	this.day = date.getDayOfMonth();
	}

	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	public static void main(String[] args) {
		MyDate date1 = new MyDate();
		System.out.println(date1);
		MyDate date2 = new MyDate(2004, 12, 3);
		System.out.println(date2);
		MyDate date3 = new MyDate(5555555555550L);
		System.out.println(date3);
    }
}

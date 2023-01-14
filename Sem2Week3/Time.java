import java.util.concurrent.TimeUnit;

public class Time
{
	private long hour, minute, second;
	
	public Time() {
		long time = System.currentTimeMillis();
		this.hour = (TimeUnit.MILLISECONDS.toHours(time) % 24) + 8; // +8 for GMT time zone difference
		this.minute = TimeUnit.MILLISECONDS.toMinutes(time) % 60;
		this.second = TimeUnit.MILLISECONDS.toSeconds(time) % 60;
	}
	
	public Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public Time(long elapsedTime) {
		this.hour = TimeUnit.MILLISECONDS.toHours(elapsedTime);
		this.minute = TimeUnit.MILLISECONDS.toMinutes(elapsedTime);
		this.second = TimeUnit.MILLISECONDS.toSeconds(elapsedTime);
	}
	
	public void setTime(long elapseTime) {
		this.hour = TimeUnit.MILLISECONDS.toHours(elapseTime) % 24;
		this.minute = TimeUnit.MILLISECONDS.toMinutes(elapseTime) % 60;
		this.second = TimeUnit.MILLISECONDS.toSeconds(elapseTime) % 60;
	}
	
	public long getHour() {
		return hour;
	}

	public void setHour(long hour) {
		this.hour = hour;
	}

	public long getMinute() {
		return minute;
	}

	public void setMinute(long minute) {
		this.minute = minute;
	}

	public long getSecond() {
		return second;
	}

	public void setSecond(long second) {
		this.second = second;
	}

	public String toString() {
		return "Time [hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
	}

	public static void main(String[] args) {
		Time now = new Time();
		Time elapse = new Time(System.currentTimeMillis());
		System.out.println(now);
		System.out.println(elapse);
		now.setTime(5555500000000000000L);
		System.out.println(now);
	}
}

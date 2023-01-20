public class Quiz implements Measurable
{
	private double score;
    private String grade;
    
    public Quiz(double score, String grade) {
    	this.score = score;
    	this.grade = grade;
    }
    
    public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public double getMeasure() {
		return score;
	}
	
	@Override
	public String toString() {
		return grade;
	}
}

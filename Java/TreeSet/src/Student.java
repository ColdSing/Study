
public class Student implements Comparable<Student>{
	private String name;
	private int num;
	private int score;
	public Student(){
	}
	public Student(String name, int num, int score) {
		this.name = name;
		this.num = num;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("������").append(this.name).append(",�༶��").append(this.num).append("���ɼ���").append(this.score).append("\n");	
		return sb.toString();
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.num-o.num;
	}
	
	
}

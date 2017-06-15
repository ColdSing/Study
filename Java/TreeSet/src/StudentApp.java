import java.util.Comparator;
import java.util.TreeSet;
/**
 * ������ʹ��TreeSet�������ڱȽϵı��������Ȼᱻ����
 * �����compare��compareTo����Ӧ���ⷵ����ֵ��
 * ������Ψһֵ��id��compare�����⸲��
 * @author ������
 *
 */
public class StudentApp {
	
	
	public static void main(String[] args) {
		TreeSet<Student> students = new TreeSet<Student>(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getScore()<o2.getScore() ?1:(o1.getScore()==o2.getScore()?o1.getName().compareTo(o2.getName()):-1);
			}
		});
		Student s1 = new Student("wx",1,100);
		Student s2 = new Student("hx",3,90);
		Student s3 = new Student("sx",2,90);
		students.add(s1);
		students.add(s2);
		students.add(s3);
		System.out.println(students);
		System.out.println("=================");
		TreeSet<Student> students1 = new TreeSet<Student>();
		students1.add(s1);
		students1.add(s2);
		students1.add(s3);
		System.out.println(students1);
	}
}

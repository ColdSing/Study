package InnerClass;

public class Outer {
	public static void main(String[] args){
		Face f= new Face();
		//�Ǿ�̬�ڲ���Ĵ����������ⲿ�����
		Face.Nose n = f.new Nose();
		//��̬�ڲ������ͨ���ⲿ��ֱ�ӵ���
		Face.ear e =new Face.ear();
	}
}
//�ⲿ�಻�ܷ����ڲ���ĳ�Ա
//�ڲ������ֱ�ӷ����ⲿ���Ա
class Face{
	int size;
	String type;
	static String color ="red";
	//�Ǿ�̬�ڲ��಻��ʹ�þ�̬��Ա�ͷ���
	class Nose{
		String type;
		void breath(){
			//�����Լ��ĳ�Ա
			System.out.println(this.type);
			//�����ⲿ���Ա
			System.out.println(Face.this.type);
		}
	}
	
	static class ear{
		
		void listen(){
			//���ܵ����ⲿ��Ǿ�̬����
			//System.out.println(Face.this.type);
			System.out.println(color);
		}
	}
}
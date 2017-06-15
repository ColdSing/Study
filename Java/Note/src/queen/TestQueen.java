package queen;

import java.util.ArrayDeque;
import java.util.Queue;
/**
 * ģ�������Ŷ�
 * @author ������
 *
 */

public class TestQueen {

	public static void main(String[] args) {
		Queue<Request> que = new ArrayDeque<Request>();
		for(int i=0 ;i<5;i++){
			final int temp = i;
			que.offer(new Request(){
				@Override
				public void deposit() {
					System.out.println("��"+temp+"����");
				}
			});
		}
		
		Request req = null;
		while(null!=(req=que.poll())){
			req.deposit();
		}
		
	}

}

interface Request{
	void deposit();
}
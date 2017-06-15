package queen;

import java.util.ArrayDeque;
import java.util.Queue;
/**
 * 模拟银行排队
 * @author 风潇潇
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
					System.out.println("第"+temp+"个人");
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
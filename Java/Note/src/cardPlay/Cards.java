package cardPlay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {
/**
 * 模拟斗地主洗牌发牌
 * @param args
 */
	public static void main(String[] args) {
		List<Integer> cards = new ArrayList<Integer>();
		for(int i=0 ;i<54;i++){
			cards.add(i);
		}
		List<Integer> p1 = new ArrayList<Integer>();
		List<Integer> p2 = new ArrayList<Integer>();
		List<Integer> p3 = new ArrayList<Integer>();
		List<Integer> last = new ArrayList<Integer>();
		Collections.shuffle(cards);
		for(int i=0;i<51;i+=3){
			p1.add(cards.get(i));
			p2.add(cards.get(i+1));
			p3.add(cards.get(i+2));
		}
		last.add(cards.get(51));
		last.add(cards.get(52));
		last.add(cards.get(53));
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(last);
	}

}

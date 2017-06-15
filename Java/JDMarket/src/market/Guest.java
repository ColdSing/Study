package market;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Guest {
	private Map <Product,Integer> trolly =new HashMap <Product,Integer>();
	private Map <Product,Integer> pack=new HashMap <Product,Integer>();
	private double money;
	public Guest(double money) {
		this.money = money;
	}
	public void takeProduct(Product p){
		if(null==trolly.get(p)){
			trolly.put(p, 1);
		}else{
			trolly.put(p,trolly.get(p).intValue()+1);
		}
	}
	public void buy(){
		Set<Entry<Product, Integer>> entrySet = trolly.entrySet();
		Iterator<Entry<Product, Integer>> itr = entrySet.iterator();
		while(itr.hasNext()){
			Entry temp=itr.next();
			pack.put((Product)temp.getKey(), (Integer)temp.getValue());
			money -= ((Product)temp.getKey()).getPrice()*(((Integer)temp.getValue()).intValue());
		}
	}
}

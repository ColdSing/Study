package market;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Market {
	private Map <Product,Integer> storage = new HashMap <Product,Integer>();
	private Map <String,Double> priceList =new HashMap <String,Double>();
	private int capacity;
	private double income;
	public Market(int capacity) {
		this.capacity = capacity;
		income = 0;
	}
	public void welcom(){
		System.out.println("*******��ӭ���뾩���̳�*******");
		System.out.println("         1.�鿴��Ʒ");
		System.out.println("         2.�����Ʒ");
		System.out.println("         3.������Ʒ");
		System.out.println("         4.�鿴���ﳵ");
		System.out.println("         5.�˳�");
	}
	public void add(Product t){
		if(isFull()){
			System.out.println("��������޷�������Ʒ��");
		}
		else{
			if(null==storage.get(t)){
				storage.put(t, 1);
				priceList.put(t.getName(), t.getPrice());
			}else{
				storage.put(t,storage.get(t).intValue()+1);
			}
		}
	}
	public Product getProduct(String name){
		if(null==priceList.get(name)){
			System.out.println("����Ʒ������");
			return null;
		}
		else
		{
			Product pro = new Product(name,priceList.get(name));
			if(storage.get(pro)==0){
				System.out.println("��Ʒ����");
				return null;
			}
			else
			{
				storage.put(pro,storage.get(pro).intValue()-1);
				return pro;
			}
		}
	}
	public void sellProduct(Product p){
		income+=priceList.get(p.getName());
	}
	public void showProduct(){
		Set<Product> keyset = storage.keySet();
		Iterator<Product> itr = keyset.iterator();
		for(;itr.hasNext();){
			Product temp = itr.next();
			System.out.println("��Ʒ��"+temp.getName()+"���ۼۣ�"+temp.getPrice());
		}
	}
	public boolean isFull(){
		int total=0;
		Set<Product> keyset = storage.keySet();
		Iterator<Product> itr = keyset.iterator();
		for(;itr.hasNext();){
			total+=(storage.get(itr.next()).intValue());
		}
		return total==capacity;
	}
}

package com.fxx.sorm.core;


/**
 * 针对Mysql数据库的增删改查方法
 * @author 风潇潇
 *
 */
public class MySqlQuery extends Query{
	public static void main(String[] args) {
//		Emp e = new Emp();
//		Class clazz = e.getClass();
//		try {
//			Field field = clazz.getDeclaredField("name");
//			System.out.println(field.getDeclaringClass());
//		} catch (NoSuchFieldException e1) {
//			e1.printStackTrace();
//		} catch (SecurityException e1) {
//			e1.printStackTrace();
//		}
		
//		String sql = "select id,name,birthday from emp where id>?";
//		Object[] params = {2};
//		List<Emp> rows =new MySqlQuery().queryRows(sql, e.getClass(), params);
//		for(Emp row :rows){
//			System.out.println(row.getName());
//		}
		//多行查询
//		String sql = "select e.id,e.name,salary+bonus 'sum',d.adress from emp e join dept d ON e.deptid=d.id";
//		
//		List<EmpVO> rows =new MySqlQuery().queryRows(sql,EmpVO.class, null);
//		for(EmpVO row :rows){
//			System.out.println(row.getId()+"-"+row.getName()+"-"+row.getSum()+"-"+row.getAdress());
//		}
		//数字查询
//		String sql = "select salary+bonus from emp where id = 1";
//		Number sum =new MySqlQuery().queryNumber(sql, null);
//		System.out.println(sum);
		
	}

	@Override
	public Object queryPagenate(int pagNum, int size) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

	
	
	

}

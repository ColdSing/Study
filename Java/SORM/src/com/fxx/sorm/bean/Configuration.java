package com.fxx.sorm.bean;
/**
 * ����������Ϣ
 * @author ������
 *
 */
public class Configuration {
	
	/**
	 * ������
	 */
	private String driver;
	/**
	 * jdbc��url
	 */
	private String url;
	/**
	 * ���ݿ��û���
	 */
	private String user;
	/**
	 * ���ݿ�����
	 */
	private String pwd;
	/**
	 * ����ʹ�õ����ݿ�
	 */
	private String usingDB;
	/**
	 * ��ĿԴ��·��
	 */
	private String srcPath;
	/**
	 * ɨ������java��İ���po����˼�ǣ�Persistence Object�־û�����
	 */
	private String poPackage;
	/**
	 * ʹ�õ���Ӧ���ݿ��query����
	 */
	private String queryClass;
	/**
	 * ���ӳ���С������
	 */
	private int poolMinSize;
	/**
	 * ���ӳ����������
	 */
	private int poolMaxSize;
	public Configuration(String driver, String url, String user, String pwd, String usingDB, String srcPath,
			String poPackage,String queryClass) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.poPackage = poPackage;
		this.queryClass=queryClass;
	}
	
	public Configuration(){
		
	}
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsingDB() {
		return usingDB;
	}

	public void setUsingDB(String usingDB) {
		this.usingDB = usingDB;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}

	public String getPoPackage() {
		return poPackage;
	}

	public void setPoPackage(String poPackage) {
		this.poPackage = poPackage;
	}
	public String getQueryClass() {
		return queryClass;
	}

	public void setQueryClass(String queryClass) {
		this.queryClass = queryClass;
	}
	public int getPoolMinSize() {
		return poolMinSize;
	}

	public void setPoolMinSize(int poolMinSize) {
		this.poolMinSize = poolMinSize;
	}

	public int getPoolMaxSize() {
		return poolMaxSize;
	}

	public void setPoolMaxSize(int poolMaxSize) {
		this.poolMaxSize = poolMaxSize;
	}

	
}

package test;

public class FileSystemClassLoader extends ClassLoader {
	private String rootDir;

	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c= findLoadedClass(name);
		if(c!=null){
			return c;
		}else{
			ClassLoader parent = this.getParent();
			try{
				c=parent.loadClass(name);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(c!=null){
				return c;
			}else{
				byte[] classData = getClassData(name);
				if(classData==null){
					throw new ClassNotFoundException();
				}else{
					c= defineClass(name, classData, 0, classData.length);
				}
			}
		}
		return c;
	}

	private byte[] getClassData(String name) {
		String path = rootDir+"/"+name.replace('.', '/')+".class";
		
		return null;
	}
}

package classload;

import java.io.InputStream;

public class ClassLoaderTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader myLoader = new ClassLoader() {

			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (Exception e) {
					throw new ClassNotFoundException();
				}
			}

		};
		
		Object obj = myLoader.loadClass("classload.ClassLoaderTest");
		
		System.out.println(obj.getClass());
		System.out.println(obj instanceof classload.ClassLoaderTest);
	}

}

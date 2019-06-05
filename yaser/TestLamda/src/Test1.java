import java.io.File;
import java.io.FileFilter;

public class Test1 {

	public static void main(String[] args) {
		
//		FileFilter filter = new FileFilter() {
//
//			@Override
//			public boolean accept (File pathname){
//				
//				return pathname.getName().endsWith(".java");
//			}
//			
//		};
		
FileFilter fileLamda = (File pathname) -> pathname.getName().endsWith(".java");
File dir = new File("d:/tmp");
File[] files = dir.listFiles(fileLamda);
for ( File f : files) {
	System.out.println(f);
}
		
	}

}

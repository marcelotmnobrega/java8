import java.io.File;
import java.io.FileFilter;

public class App {

    public static void main (String[] args){
        FileFilter filterLambda = (File pathname) -> pathname.getName().endsWith(".java");
        File dir = new File("D:\\mtmn\\OneDrive\\Documents\\dev\\java\\java8\\src\\main\\java");
        File[] files = dir.listFiles(filterLambda);
        for (File file : files) {
            System.out.println(file);
        }
    }

    public static void main2 (String[] args){
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };
        File dir = new File("D:\\mtmn\\OneDrive\\Documents\\dev\\java\\java8\\src\\main\\java");
        File[] files = dir.listFiles(filter);
        for (File f : files){
            System.out.println(f);
        }
    }
}

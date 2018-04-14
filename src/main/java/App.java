import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class App {

    public static void main (String[] args){

        List<String> list = Arrays.asList("Hello, World!", "Welcome to CoderPad.", "This pad is running Java 8.");
        list.parallelStream().forEach(System.out::println);
        
        Stream<String> stream = Stream.of("One", "Two", "Three", "Four", "Five");
        Predicate<String> p2 = Predicate.isEqual("Two");
        Predicate<String> p3 = Predicate.isEqual("Three");
        stream
                .filter(s -> s.length() > 3)
                .filter(p2.or(p3))
                .forEach(System.out::println);

        //Optional<String> one = stream.findAny();
        //System.out.println(one.isPresent()?one.get():"null");
        //stream.forEach(System.out::println);

    }

    public static void main3 (String[] args){
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

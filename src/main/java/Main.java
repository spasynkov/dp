import singleton.Singleton;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance();
        System.out.println(instance);

        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance2);


        List<String> a = new LinkedList<>();

        a.add("hfhf");
        a.add("rrtr");
        a.add("eoeo");

        a.forEach(System.out::println);






    }



}

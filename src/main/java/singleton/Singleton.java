package singleton;

public class Singleton {

    private static Singleton instance;


    private static final Object KEYS = new Object();

    public static Singleton getInstance() {



        if(instance == null){

           synchronized (KEYS){
               if(instance == null){
               instance = new Singleton();
               }
           }
        }


        return instance;
    }

    private Singleton() {
    }
}

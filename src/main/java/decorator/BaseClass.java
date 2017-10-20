package decorator;

public class BaseClass {
    private String string;
    private int i;

    public BaseClass(String string, int i) {
        this.string = string;
        this.i = i;
    }

    public String firstMethod() {
        System.out.println("Вызван первый метод базового класса");
        return string;
    }

    public int secondMethod() {
        System.out.println("Вызван второй метод базового класса");
        return i;
    }

    public void thirdMethod() {
        System.out.println("Вызван третий метод базового класса");
    }
}

package singleton;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SingletonTest {
    @Test
    public void testClass() {
        Class<Singleton> singletonClass = Singleton.class;
        Method[] methods = singletonClass.getDeclaredMethods();

        // проверяем количество методов класса
        // не учитываем те методы, которые были унаследованы от класса Object
        final List<String> objectMethodsNames = Arrays.stream(Object.class.getDeclaredMethods())
                .map(Method::getName)       // собираем имена методов класса Object
                .collect(Collectors.toList());
        List<Method> classMethods = Arrays.stream(methods)
                // берем только те методы класса, названий которых нет в списке имен методов класса Object
                .filter(m -> !objectMethodsNames.contains(m.getName()))
                .collect(Collectors.toList());
        Assert.assertTrue("В классе слишком много или слишком мало методов. Ожидается только один метод",
                classMethods.size() == 1);

        Method method = classMethods.get(0);
        //System.out.println(method.getName() + " " + method.getModifiers());
        Assert.assertTrue("Неправильные модификаторы метода. Ожидается public static",
                method.getModifiers() == 9);

        Assert.assertTrue("В методе слишком много параметров. Ожидается метод без параметров",
                method.getParameterCount() == 0);

        Assert.assertTrue("Неправильное возвращаемое значение метода. Ожидается Singleton",
                method.getReturnType() == Singleton.class);

        Assert.assertTrue("В классе есть доступные конструкторы, а значит есть возможность создать обьект класса " +
                        "напрямую. Ожидается, что в классе не будут доступны конструкторы вообще",
                singletonClass.getConstructors().length == 0);
    }

    @Test
    public void testInstances() throws InterruptedException {
        Singleton o1 = Singleton.getInstance();
        Thread.sleep(100);
        Singleton o2 = Singleton.getInstance();

        Assert.assertTrue("Первый вызов метода вернул null вместо обьекта",
                o1 != null);
        Assert.assertTrue("Второй вызов метода вернул null вместо обьекта",
                o2 != null);
        Assert.assertEquals("Вызов метода getInstance() вернул разные обьекты",
                o1, o2);
        Assert.assertTrue("Вызов метода getInstance() вернул разные ссылки на обьекты",
                o1 == o2);
    }
}
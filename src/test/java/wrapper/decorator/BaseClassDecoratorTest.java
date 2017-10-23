package wrapper.decorator;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class BaseClassDecoratorTest {
    @Test
    public void test1() {
        BaseClass mock = mock(BaseClass.class);
        BaseClassDecorator decorator = new BaseClassDecorator(mock);

        // вызываем метод декоратора и проверяем, что методы основного класса не вызывались
        decorator.decoratedMethod();
        verify(mock, never()).firstMethod();
        verify(mock, never()).secondMethod();
        verify(mock, never()).thirdMethod();

        // вызываем первый метод и проверяем, что был вызван первый метод один раз, а остальные ни разу не вызывались
        decorator.firstMethod();
        verify(mock).firstMethod();
        verify(mock, never()).secondMethod();
        verify(mock, never()).thirdMethod();

        // вызываем второй метод и проверяем, что были вызваны первый и второй методы ровно 1 раз, а третий не вызывался
        decorator.secondMethod();
        verify(mock).firstMethod();
        verify(mock).secondMethod();
        verify(mock, never()).thirdMethod();

        // вызываем третий метод и проверяем, что был вызван каждый метод базового класа ровно 1 раз
        decorator.thirdMethod();
        verify(mock).firstMethod();
        verify(mock).secondMethod();
        verify(mock).thirdMethod();
    }
}
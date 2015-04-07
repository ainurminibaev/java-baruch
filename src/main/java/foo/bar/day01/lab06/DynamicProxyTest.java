package foo.bar.day01.lab06;

import foo.bar.day01.lab05.RealSubject;
import foo.bar.day01.lab05.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ainurminibaev on 06.04.15.
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            private Subject realSubject = new RealSubject();
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long start = System.currentTimeMillis();
                Object result = method.invoke(realSubject);
                long end = System.currentTimeMillis();
                System.out.println(end - start);
                return result;
            }
        };
        Subject subject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[]{Subject.class}, handler);
        subject.call();
    }
}

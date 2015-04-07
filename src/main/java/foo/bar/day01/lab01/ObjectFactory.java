package foo.bar.day01.lab01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ainurminibaev on 06.04.15.
 */
public class ObjectFactory {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Class clazz = Class.forName("jbaruch2015.lab01.Robot");
        Object o = clazz.newInstance();
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            RunThisMethod annotation = method.getAnnotation(RunThisMethod.class);
            if (annotation != null) {
                int repeat = annotation.repeat();
                for (int j = 0; j < repeat; j++) {
                    method.invoke(o);
                }
            }
        }
        System.out.println(o);
    }
}

package foo.bar.day01.lab04;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Field> fieldsToSetThroughSetter = new HashMap<String, Field>();
    private Random random = new Random();

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Class clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            injectIntToField(o, field);
        }
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            InjectRandomInt annotation = method.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                injectRandomIntToMethod(o, method, annotation);
            } else {
                String propertyName = getPropertyNameFromSetterOrNull(method.getName());
                Field field = fieldsToSetThroughSetter.get(propertyName);
                if (field != null) {
                    annotation = field.getAnnotation(InjectRandomInt.class);
                    if (annotation != null) {
                        injectRandomIntToMethod(o, method, annotation);
                    }
                    fieldsToSetThroughSetter.remove(propertyName);
                }
            }
        }
        for (String name : fieldsToSetThroughSetter.keySet()) {
            System.out.println("Couldn't inject int to field " + name);
        }
        return o;
    }

    private void injectIntToField(Object o, Field field) {
        InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
        if (annotation != null) {
            int min = annotation.min();
            int max = annotation.max();
            if (Integer.class.equals(field.getType()) || int.class.equals(field.getType()))
                if (Modifier.isPublic(field.getModifiers())) {
                    try {
                        field.set(o, random.nextInt(max - min) + min);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    fieldsToSetThroughSetter.put(field.getName(), field);
                }
        }
    }

    private void injectRandomIntToMethod(Object o, Method method, InjectRandomInt annotation) {
        if (Modifier.isPublic(method.getModifiers())) {
            int min = annotation.min();
            int max = annotation.max();
            Class[] clazzes = method.getParameterTypes();
            if (clazzes.length == 1 && Integer.class.equals(clazzes[0]) || int.class.equals(clazzes[0])) {
                try {
                    method.invoke(o, random.nextInt(max - min) + min);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Can not inject int to method " + method.getName());
            }
        } else {
            System.out.println(method.getName() + " is not public");
        }
    }

    private String getPropertyNameFromSetterOrNull(String name) {
        if (name.startsWith("set")) {
            String propertyName = name.substring(3);
            propertyName = decapitalize(propertyName);
            return propertyName;
        }
        return null;
    }

    private String decapitalize(final String line) {
        return Character.toLowerCase(line.charAt(0)) + line.substring(1);
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
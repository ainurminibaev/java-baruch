package foo.bar.day01.lab04;

import foo.bar.day01.lab01.RunThisMethod;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;

/**
 * Created by ainurminibaev on 06.04.15.
 */
public class RunWithThisMethodPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        try {
            for (Method method : bean.getClass().getMethods()) {
                RunThisMethod annotation = method.getAnnotation(RunThisMethod.class);
                if (annotation != null) {
                    int repeat = annotation.repeat();
                    for (int j = 0; j < repeat; j++) {
                        method.invoke(bean);
                    }
                }
            }
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println(o);
        System.out.println(s);
        return o;
    }
}

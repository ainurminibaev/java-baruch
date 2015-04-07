package foo.bar.day01.lab07;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ainurminibaev on 06.04.15.
 */
public class ProxyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(final Object bean, String s) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String s) throws BeansException {
        return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (bean.getClass().getMethod(method.getName(), method.getParameterTypes()).getAnnotation(BenchMark.class) == null) {
                    return method.invoke(bean, args);
                }
                long start = System.currentTimeMillis();
                Object result = method.invoke(bean, args);
                System.out.println("Measure :" + (System.currentTimeMillis() - start));
                return result;
            }
        });
    }
}

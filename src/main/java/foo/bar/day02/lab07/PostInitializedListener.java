package foo.bar.day02.lab07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by ainurminibaev on 07.04.15.
 */
@Component
public class PostInitializedListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String defName : definitionNames) {
            Object bean = applicationContext.getBean(defName);
            Class<?> beanClass = bean.getClass();
            for (Method m : beanClass.getMethods()) {
                if (m.getAnnotation(PostInitialized.class) != null) {
                    try {
                        m.invoke(bean);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new IllegalStateException(e);
                    }
                }
            }
        }
    }
}

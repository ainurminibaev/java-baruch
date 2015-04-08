package foo.bar.day02.lab10;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@Component
@Aspect
public class ReplaceImplAspect {

    @Around("@annotation(MyDeprecated)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MyDeprecated annotation = method.getAnnotation(MyDeprecated.class);
        if (annotation != null) {
            return annotation.replaceWith().getConstructor(int.class).newInstance(joinPoint.proceed());
        }
        return joinPoint.proceed(); //continue on the intercepted method
    }
}

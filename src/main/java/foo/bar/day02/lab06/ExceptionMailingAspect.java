package foo.bar.day02.lab06;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@Component
@Aspect
public class ExceptionMailingAspect {

    @Resource(name = "mailToList")
    private List<String> mailToList;

    public List<String> getMailToList() {
        return mailToList;
    }

    @Around("execution(* foo.bar.day02.lab06.Repository+.*(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("logAround() is running!");
        System.out.println("hijacked method : " + joinPoint.getSignature().getName());
        System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        try {
            joinPoint.proceed(); //continue on the intercepted method
        } catch (DatabaseException e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            System.out.println("Mail to " + mailToList);
            System.out.println("Message: " + sw.toString());
        }
        System.out.println("Around after is running!");

        System.out.println("******");

    }
}

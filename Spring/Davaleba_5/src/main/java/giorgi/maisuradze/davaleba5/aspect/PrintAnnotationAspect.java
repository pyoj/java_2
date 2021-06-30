package giorgi.maisuradze.davaleba5.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class PrintAnnotationAspect {

    @Before("@annotation(Println)")
    public void multiplicationTask(JoinPoint joinPoint) {
        System.out.println("გადაცემული არგუმენტები: " + Arrays.toString(joinPoint.getArgs()));
    }

}

package personal.ivan.textparseservice.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@Component
@Aspect
public class AspectLogger {
    @Around("execution(* personal.ivan.textparseservice.restapi.controller.MyController.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) {
        try {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            FileWriter writer = new FileWriter("logs.txt", true);
            writer.write("Method invoked " + joinPoint + "\n");
            long beforeExecution = System.currentTimeMillis();
            Object res = joinPoint.proceed();
            long afterExecution = System.currentTimeMillis();
            long result = afterExecution - beforeExecution;
            if (result > 100) {
                writer.write("WARNING " + joinPoint + " " + timestamp + " " + result + "\n\n");
            } else {
                writer.write("method finished " + joinPoint + " " + timestamp + " " + result + "\n\n");
            }
            writer.flush();
            return res;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /*@Before("execution(* personal.ivan.textparseservice.restapi.controller.MyController.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        try {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            FileWriter writer = new FileWriter("logs.txt", true);
            writer.write("logBefore " + joinPoint.toString() + " " + timestamp + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After("execution(* personal.ivan.textparseservice.restapi.controller.MyController.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        try {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            FileWriter writer = new FileWriter("logs.txt", true);
            writer.write("logAfter " + joinPoint.toString() + " " + timestamp + "\n\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    @AfterThrowing(pointcut = "execution(* personal.ivan.textparseservice.restapi.controller.MyController.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint,Exception ex) {
        try {
            FileWriter writer = new FileWriter("logs.txt", true);
            writer.write("Method invoked "+ joinPoint +"\n");
            writer.write("logException " + ex.getMessage() + "\n\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

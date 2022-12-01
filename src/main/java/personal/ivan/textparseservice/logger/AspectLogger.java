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
            Object res = null;
            try {
                res = joinPoint.proceed();
            } catch (Throwable ex) {
                writer.write("log exception with args: " + joinPoint.getArgs()[0].toString() + "\n");
            }
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
            e.getStackTrace();
        }
        return null;
    }
}

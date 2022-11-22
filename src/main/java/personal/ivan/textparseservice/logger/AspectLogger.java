package personal.ivan.textparseservice.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@Component
@Aspect
public class AspectLogger {

    @Before("execution(* personal.ivan.textparseservice.restapi.controller.MyController.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        try {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            FileWriter writer = new FileWriter("logs.txt", true);
            writer.write(joinPoint.toString() + " " + timestamp + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

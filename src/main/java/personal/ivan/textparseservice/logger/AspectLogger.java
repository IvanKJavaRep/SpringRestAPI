package personal.ivan.textparseservice.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
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
    }
    @AfterThrowing("execution(* personal.ivan.textparseservice.restapi.controller.MyController.*(..))")
    public void logException(JoinPoint joinPoint) {
        try {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            FileWriter writer = new FileWriter("logs.txt", true);
            writer.write("logException " + joinPoint.toString() + " " + timestamp + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

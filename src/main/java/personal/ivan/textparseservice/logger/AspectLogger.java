package personal.ivan.textparseservice.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
@Aspect
public class AspectLogger {
    @Around("execution(* personal.ivan.textparseservice.restapi.controller.MyController.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) {
        try {
            FileWriter writer = new FileWriter("logs.txt", true);
            writer.write("Method invoked " + joinPoint + "\n");
            long beforeExecution = System.currentTimeMillis();
            Object res = null;
            try {
                res = joinPoint.proceed();
            } catch (Throwable ex) {
                String output = "log exception with args: ";
                for (var el :
                        joinPoint.getArgs()) {
                    if (el instanceof List<?>) {
                        output += "List size: " + ((List<?>) el).size();
                    } else {
                        output += el;
                    }
                }
                writer.write(output + "\n");
            }
            long afterExecution = System.currentTimeMillis();
            long result = afterExecution - beforeExecution;
            if (result > 100) {
                writer.write("WARNING " + joinPoint + " " + " " +
                        LocalDate.now() + " " + LocalDate.now().getDayOfWeek().toString()
                        + " " + LocalTime.now().toString()
                        + " " + result + "\n\n");
            } else {
                writer.write("method finished " + joinPoint + " " +
                        LocalDate.now() + " " + LocalDate.now().getDayOfWeek().toString()
                        + " " + LocalTime.now().toString()
                        + " " + result + "\n\n");
            }
            writer.flush();
            return res;
        } catch (Throwable e) {
            e.getStackTrace();
        }
        return null;
    }
}

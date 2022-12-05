package personal.ivan.textparseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import personal.ivan.textparseservice.data.IMyDTORepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class ScheduledService {

    @Autowired
    IMyDTORepository myDTORepository;

    @Scheduled(cron = "0 0 23 * * *")
    public void scheduledMidNight() {
    }

    @Scheduled(fixedDelay = 10000)
    public void scheduledEveryMinute() {
        LocalDateTime localDateTime = LocalDateTime.now();
        myDTORepository.updateDataBase(Timestamp.valueOf(localDateTime));
    }
}

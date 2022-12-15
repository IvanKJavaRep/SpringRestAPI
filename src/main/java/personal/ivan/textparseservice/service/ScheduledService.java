package personal.ivan.textparseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import personal.ivan.textparseservice.dao.MyTableDao;
import personal.ivan.textparseservice.dao.entity.MyTableEntity;
import personal.ivan.textparseservice.dao.entity.Status;
import personal.ivan.textparseservice.data.IMyDTORepository;
import personal.ivan.textparseservice.mapper.MyTableMapper;
import personal.ivan.textparseservice.restapi.dto.MyDTO;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;

@Configuration
@EnableScheduling
public class ScheduledService {
    @Autowired
    MyTableDao myTableDao;
    @Autowired
    MyTableMapper myTableMapper;

    @Autowired
    IMyDTORepository myDTORepository;

    @Scheduled(cron = "${job.cron}")
    public void scheduledMidNight() {
    }

    @Scheduled(fixedRateString = "${job.schedules}")
    public void scheduledEveryMinute() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Collection<MyTableEntity> resultSet = myDTORepository.selectDataBase(Timestamp.valueOf(localDateTime));
        for (var el :
                resultSet) {
            int r = el.getUpdateTime().compareTo(Timestamp.valueOf(localDateTime.minusDays(2)));
            if (r < 0) {
                el.setStatus(Status.error);
            } else {
                el.setStatus(Status.completed);
            }
            myTableDao.save(el);
        }

    }
}

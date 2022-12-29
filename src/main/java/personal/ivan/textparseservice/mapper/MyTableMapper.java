package personal.ivan.textparseservice.mapper;

import org.springframework.stereotype.Component;
import personal.ivan.textparseservice.dao.entity.MyTableEntity;
import personal.ivan.textparseservice.dao.entity.Status;
import personal.ivan.textparseservice.restapi.dto.MyDTO;

@Component
public class MyTableMapper {
    public MyTableEntity dtoToEntity(MyDTO myDTO) {
        return MyTableEntity.builder()
                .id(myDTO.getId())
                .name(myDTO.getName())
                .address(myDTO.getAddress())
                .build();
    }
}

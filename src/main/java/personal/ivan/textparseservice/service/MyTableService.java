package personal.ivan.textparseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.ivan.textparseservice.dao.MyTableDao;
import personal.ivan.textparseservice.dao.entity.MyTableEntity;
import personal.ivan.textparseservice.mapper.MyTableMapper;
import personal.ivan.textparseservice.restapi.dto.MyDTO;

@Service
public class MyTableService {
    @Autowired
    MyTableDao myTableDao;
    @Autowired
    MyTableMapper myTableMapper;
    public void createEntity(MyDTO myDTO)
    {
        myTableDao.save(myTableMapper.dtoToEntity(myDTO));
    }
    public void deleteEntity(int id)
    {
        myTableDao.delete(id);
    }
    public void updateEntity(int id, String address)
    {
        myTableDao.updateAddress(id, address);
    }
    public MyTableEntity getEntity(int id)
    {
        return myTableDao.get(id);
    }
}

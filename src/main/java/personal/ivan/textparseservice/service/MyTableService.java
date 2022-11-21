package personal.ivan.textparseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public void transactionFail()
    {
        myTableDao.updateAddress(21, "new address");
        myTableDao.updateUserAddress(1, "Petr");
        // здесь будет ошибка, так как такого id нет и транзакция откатится
        myTableDao.get(23);

    }
    @Transactional
    public void transaction()
    {
        //обе команды сработают без исключений и транзакция пройдет
        System.out.println(myTableDao.get(21).getAddress());
        myTableDao.updateAddress(21, "new address");
        myTableDao.updateUserAddress(1, "Petr");
    }
    @Transactional(noRollbackFor = Exception.class )
    public void getUndefinedObj()
    {
        myTableDao.updateAddress(21, "noRollBack");
        myTableDao.get(21);
        myTableDao.updateUserAddress(1, "Alex");
        //здесь будет исключение, но адрес все равно обновится на noRollBack
        // так как транзакция не реагирует на исключения
        myTableDao.get(23);
    }
}

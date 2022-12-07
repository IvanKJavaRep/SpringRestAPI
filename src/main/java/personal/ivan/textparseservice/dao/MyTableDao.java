package personal.ivan.textparseservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import personal.ivan.textparseservice.dao.entity.MyTableEntity;
import personal.ivan.textparseservice.data.IMyDTORepository;
import personal.ivan.textparseservice.data.IUsersRepository;

@Service
public class MyTableDao {
    @Autowired
    IMyDTORepository myDTORepository;
    @Autowired
    IUsersRepository usersRepository;

    public void save(MyTableEntity myTableEntity) {
        myDTORepository.save(myTableEntity);
    }

    public void delete(int id) {
        myDTORepository.deleteById(id);
    }

    public void updateAddress(int id, String address) {
        var obj = myDTORepository.findById(id).get();
        obj.setAddress(address);
        myDTORepository.save(obj);
    }

    public void updateUserAddress(int id, String address) {
        var obj = usersRepository.findById(id).get();
        obj.setName(address);
        usersRepository.save(obj);
    }

    @Cacheable(value = "MyTableEntity")
    public MyTableEntity get(int id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myDTORepository.findById(id).get();
    }

    @CachePut(value = "MyTableEntity")
    public MyTableEntity getWithCachePut(int id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myDTORepository.findById(id).get();
    }

    @CachePut(value = "MyTableEntity",condition = "#id==47")
    public MyTableEntity getWithCachePutCondition(int id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myDTORepository.findById(id).get();
    }

    @CacheEvict(value = "MyTableEntity", beforeInvocation = true)
    public void deleteById(int id) {
    }
}

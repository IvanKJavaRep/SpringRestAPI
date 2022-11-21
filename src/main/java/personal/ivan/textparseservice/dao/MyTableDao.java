package personal.ivan.textparseservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
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

    public MyTableEntity get(int id) {
        return myDTORepository.findById(id).get();
    }
}

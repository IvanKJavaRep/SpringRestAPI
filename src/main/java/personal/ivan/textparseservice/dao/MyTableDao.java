package personal.ivan.textparseservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.ivan.textparseservice.dao.entity.MyTableEntity;
import personal.ivan.textparseservice.data.IMyDTORepository;

@Service
public class MyTableDao {
    @Autowired
    IMyDTORepository myDTORepository;

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
    public MyTableEntity get(int id)
    {
        return myDTORepository.findById(id).get();
    }
}

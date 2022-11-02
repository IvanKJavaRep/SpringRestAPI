package personal.ivan.textparseservice.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import personal.ivan.textparseservice.data.IMyDTORepository;
import personal.ivan.textparseservice.data.MyDTO;

import java.util.Optional;

@Controller
@RequestMapping(value = "/myservice")
public class MyController {

    @Autowired
    IMyDTORepository repo;


    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<MyDTO> getMyData(@PathVariable int id) {
        return repo.findById(id);
    }


    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    @ResponseBody
    public void putMyData(@RequestParam int id) {
        var obj = repo.findById(id).get();
        obj.setAddress("llll");
        repo.save(obj);
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public void postMyData(@RequestBody MyDTO md) {
        System.out.println(md.getId());
        repo.save(md);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteMyData(@PathVariable int id) {
        repo.deleteById(id);
    }

    @RequestMapping(value = "/request-header-test", method = RequestMethod.POST)
    @ResponseBody
    public void testMaxHTTPHeaderSize(@RequestParam String token) {
    }

}

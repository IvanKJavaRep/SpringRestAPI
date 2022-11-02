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
    public MyDTO putMyData(@RequestBody MyDTO md) {
        return md;
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public MyDTO postMyData(@RequestParam int id) {
        return repo.getReferenceById(id);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public MyDTO deleteMyData(@PathVariable int id) {
        return repo.getReferenceById(id);
    }

    @RequestMapping(value = "/request-header-test", method = RequestMethod.POST)
    @ResponseBody
    public void testMaxHTTPHeaderSize(@RequestParam String token) {

    }

}

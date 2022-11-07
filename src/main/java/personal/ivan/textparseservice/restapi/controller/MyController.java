package personal.ivan.textparseservice.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import personal.ivan.textparseservice.data.IMyDTORepository;
import personal.ivan.textparseservice.dao.entity.MyTableEntity;
import personal.ivan.textparseservice.restapi.dto.MyDTO;
import personal.ivan.textparseservice.service.MyTableService;

import java.util.Optional;

@Controller
@RequestMapping(value = "/myservice")
public class MyController {


    @Autowired
    MyTableService myTableService;


    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MyTableEntity getMyData(@PathVariable int id) {
        return myTableService.getEntity(id);
    }


    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    @ResponseBody
    public void putMyData(@RequestParam int id) {
        myTableService.updateEntity(id, "new address");
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public void postMyData(@RequestBody MyDTO md) {
        System.out.println(md.getId());
        myTableService.createEntity(md);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteMyData(@PathVariable int id) {
        myTableService.deleteEntity(id);
    }

    @RequestMapping(value = "/request-header-test", method = RequestMethod.POST)
    @ResponseBody
    public void testMaxHTTPHeaderSize(@RequestParam String token) {
    }

}

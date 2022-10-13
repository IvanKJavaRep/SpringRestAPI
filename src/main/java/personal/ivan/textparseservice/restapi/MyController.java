package personal.ivan.textparseservice.restapi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
@Controller
@RequestMapping(value = "/myservice")
public class MyController {

    @RequestMapping(value= "/{time}", method = RequestMethod.GET)
    @ResponseBody
    public MyDTO getMyData(@PathVariable long time) {
        return new MyDTO(Calendar.getInstance(), "Это ответ метода GET!");
    }


    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public MyDTO putMyData(@RequestBody MyDTO md) {
        return md;
    }


    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public MyDTO postMyData() {
        return new MyDTO(Calendar.getInstance(), "это ответ метода POST!");
    }


    @RequestMapping(value= "/{time}", method = RequestMethod.DELETE)
    @ResponseBody
    public MyDTO deleteMyData(@PathVariable long time) {
        return new MyDTO(Calendar.getInstance(), "Это ответ метода DELETE!");
    }
}

package personal.ivan.textparseservice.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@Controller
@RequestMapping(value = "/myservice")
public class MyController {



    @RequestMapping(value = "/get/{time}", method = RequestMethod.GET)
    @ResponseBody
    public MyDTO getMyData(@PathVariable long time) {
        return new MyDTO(Calendar.getInstance(), "Это ответ метода GET!");
    }


    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    @ResponseBody
    public MyDTO putMyData(@RequestBody MyDTO md) {
        return md;
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public MyDTO postMyData(@RequestParam String phrase) {
        return new MyDTO(Calendar.getInstance(), "это ответ метода POST: переданный " +
                "параметр равен " + phrase);
    }


    @RequestMapping(value = "/delete/{time}", method = RequestMethod.DELETE)
    @ResponseBody
    public MyDTO deleteMyData(@PathVariable long time) {
        return new MyDTO(Calendar.getInstance(), "Это ответ метода DELETE!");
    }

}

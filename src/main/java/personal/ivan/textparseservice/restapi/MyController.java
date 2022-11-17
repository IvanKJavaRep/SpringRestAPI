package personal.ivan.textparseservice.restapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import personal.ivan.textparseservice.security.AuthService;
import personal.ivan.textparseservice.security.JWTRequest;
import personal.ivan.textparseservice.security.JWTResponse;

import java.util.Calendar;

@Controller
@RequestMapping(value = "/myservice")
@RequiredArgsConstructor
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


    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{time}", method = RequestMethod.DELETE)
    @ResponseBody
    public MyDTO deleteMyData(@PathVariable long time) {
        return new MyDTO(Calendar.getInstance(), "Это ответ метода DELETE!");
    }


    /*@RequestMapping(value = "/registration")
    public String testMaxHTTPHeaderSize(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }*/
    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest authRequest) {
        final JWTResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }
}

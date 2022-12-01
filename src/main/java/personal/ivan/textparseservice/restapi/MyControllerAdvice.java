package personal.ivan.textparseservice.restapi;

import org.apache.coyote.http11.HeadersTooLargeException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Calendar;

@EnableWebMvc
@RestControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    @ResponseBody
    public String requestHandlingNoHandlerFound(final BadCredentialsException ex) {
        return "There is no method with such name \n Status: 404";
    }


}

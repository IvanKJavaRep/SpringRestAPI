package personal.ivan.textparseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class SourceClass {

    @Autowired
    public SourceClass(Config c) {
        System.out.println(c.getPort());
    }
}

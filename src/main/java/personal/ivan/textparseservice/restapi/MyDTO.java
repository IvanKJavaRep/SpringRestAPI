package personal.ivan.textparseservice.restapi;

import java.util.Calendar;

public class MyDTO {
    private Calendar time;
    private String message;

    public MyDTO(Calendar time, String message) {
        this.time = time;
        this.message = message;
    }

    public MyDTO() {
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

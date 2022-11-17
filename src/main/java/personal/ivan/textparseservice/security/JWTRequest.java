package personal.ivan.textparseservice.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTRequest {
    private String login;
    private String password;
}

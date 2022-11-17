package personal.ivan.textparseservice.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest authRequest) {
        final JWTResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("token")
    public ResponseEntity<JWTResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) {
        final JWTResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("refresh")
    public ResponseEntity<JWTResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
        final JWTResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

}

package personal.ivan.textparseservice;

import org.junit.jupiter.api.Test;

public class JWTTest {
    @Test
    public void test()
    {
        System.out.println(GenerateJWT.parseJwt(GenerateJWT.jwtToken));
    }
}

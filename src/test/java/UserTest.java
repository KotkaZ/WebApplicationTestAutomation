import org.junit.Test;

public class UserTest extends TestHelper  {
    private String username = "admin";
    private String password = "admin";


    @Test
    public void registerAccount() {
        driver.get(baseUrlAdmin);

    }
}

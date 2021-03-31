import org.junit.Test;
import org.openqa.selenium.By;

public class AdminTest extends TestHelper  {
    private String username = "admin";
    private String password = "admin";


    @Test
    public void registerAccount() {
        driver.get(baseUrlAdmin);

    }
}

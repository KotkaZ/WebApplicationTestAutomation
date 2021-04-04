import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasicTest extends TestHelper {


    private String username = "admin";
    private String password = "admin";

    @Test
    public void titleExistsTest(){
        String expectedTitle = "ST Online Store";
        String actualTitle = driver.getTitle();

        assertEquals(expectedTitle, actualTitle);
    }


    /*
    In class Exercise

    Fill in loginLogoutTest() and login mehtod in TestHelper, so that the test passes correctly.

     */
    @Test
    public void loginLogoutTest(){

        login(username, password);

        // assert that correct page appeared
        // WebElement adminHeader = driver.findElement...
        // ...
        boolean isPresent = isElementPresent(By.linkText("New product"));
        assertTrue(isPresent);

        logout();
    }

    /*
    In class Exercise

     Write a test case, where you make sure, that one can’t log in with a false password

     */
    @Test
    public void loginFalsePassword() {
        login(username, "Wrong password");
        Assert.assertEquals("Invalid user/password combination", driver.findElement(By.id("notice")).getText());
    }


}

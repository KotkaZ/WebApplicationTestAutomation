
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class AdminTest extends TestHelper  {

    @Before
    public void before() {
        register();
    }

    @Test
    public void registerAccount() {

        boolean isPresent = isElementPresent(By.xpath("//a[contains(text(), 'Delete')]"));
        assertTrue(isPresent);

        driver.get(baseUrlAdmin);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("Delete")).click();

    }

    @Test
    public void deleteAccount() {

        driver.get(baseUrlAdmin);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("Delete")).click();
        String deleteString = driver.findElement(By.id("notice")).getText();
        assertEquals("User was successfully deleted.", deleteString);
    }

    @Test
    public void addProduct() {
        driver.findElement(By.linkText("New product")).click();

        driver.findElement(By.id("product_title")).sendKeys("testItem");
        driver.findElement(By.id("product_description")).sendKeys("testItem desc");
        Select type = new Select(driver.findElement(By.id("product_prod_type")));
        type.selectByValue("Books");
        driver.findElement(By.id("product_price")).sendKeys("20");

        driver.findElement(By.name("commit")).click();
        driver.findElement(By.id("testItem")).findElement(By.linkText("Delete")).click();

        assertFalse(driver.findElements(By.id("testItem")).size() > 0);

        driver.get(baseUrlAdmin);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("Delete")).click();
    }

    @Test
    public void editProduct() {
        driver.findElement(By.linkText("New product")).click();

        driver.findElement(By.id("product_title")).sendKeys("testItem");
        driver.findElement(By.id("product_description")).sendKeys("testItem desc");
        Select type = new Select(driver.findElement(By.id("product_prod_type")));
        type.selectByValue("Books");
        driver.findElement(By.id("product_price")).sendKeys("20");
        driver.findElement(By.name("commit")).click();

        driver.findElement(By.id("testItem")).findElement(By.linkText("Edit")).click();

        driver.findElement(By.id("product_title")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "testItemEdited");
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.linkText("Back")).click();

        assertTrue(driver.findElements(By.id("testItemEdited")).size() > 0);

        driver.findElement(By.id("testItemEdited")).findElement(By.linkText("Delete")).click();

        driver.get(baseUrlAdmin);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("Delete")).click();
    }

    @Test
    public void deleteProduct() {
        driver.findElement(By.linkText("New product")).click();

        driver.findElement(By.id("product_title")).sendKeys("testItem");
        driver.findElement(By.id("product_description")).sendKeys("testItem desc");
        Select type = new Select(driver.findElement(By.id("product_prod_type")));
        type.selectByValue("Books");
        driver.findElement(By.id("product_price")).sendKeys("20");
        driver.findElement(By.name("commit")).click();

        driver.findElement(By.id("testItem")).findElement(By.linkText("Delete")).click();

        assertFalse(driver.findElements(By.id("testItem")).size() > 0);

        driver.get(baseUrlAdmin);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("Delete")).click();
    }


}

import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Scanner;

public class UserUpdate extends Utils{
    public UserUpdate(String url) {
        super(url);
        driver.findElement(By.cssSelector("#app > section > main > div.left > ul > li:nth-child(4)")).click();
    }

    // 检查页面是否加载成功
    public void loginPageRight() throws InterruptedException, IOException {
        //通过查看页面元素是否存在来检查页面加载成功与否
        driver.findElement(By.cssSelector("#update-nickname"));
    }

    // 检查用户修改个人信息功能---成功修改
    public void updateUserRight() throws IOException {
        driver.findElement(By.cssSelector("#update-nickname")).clear();
        driver.findElement(By.cssSelector("#update-email")).clear();
        driver.findElement(By.cssSelector("#update-introduce")).clear();

        driver.findElement(By.cssSelector("#update-nickname")).sendKeys("zhangsan");
        driver.findElement(By.cssSelector("#update-email")).sendKeys("jingbiaoh@163.com");
        driver.findElement(By.cssSelector("#update-introduce")).sendKeys("哥只是个传说");

        driver.findElement(By.cssSelector("#update-button")).click();

        // 判断修改后的元素是否一致
        assert (driver.findElement(By.cssSelector("#update-nickname")).getText().equals("zhangsan"));

        getScreenShot(getClass().getName());
    }

    // 检查用户修改手机号码功能---成功修改
    public void updatePhoneRight() throws IOException {
        driver.findElement(By.cssSelector("#update-phone")).clear();
        driver.findElement(By.cssSelector("#update-code")).clear();

        driver.findElement(By.cssSelector("#update-phone")).sendKeys("19898126695");
        driver.findElement(By.cssSelector("#code-button")).click();
        String code = new Scanner(System.in).nextLine();
        driver.findElement(By.cssSelector("#update-code")).sendKeys(code);

        driver.findElement(By.cssSelector("#update-button")).click();

        // 判断修改后的元素是否一致
        assert (driver.findElement(By.cssSelector("#update-phone")).getText().equals("19898126695"));

        getScreenShot(getClass().getName());
    }
}

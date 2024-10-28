import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Scanner;

public class UserReg extends Utils{

    public UserReg(String url) {
        super(url);
        driver.findElement(By.cssSelector("#reg-button")).click();
    }

    // 检查页面是否加载成功
    public void regPageRight() throws InterruptedException, IOException {
        //通过查看页面元素是否存在来检查页面加载成功与否
        driver.findElement(By.cssSelector("#again-pass-input"));
    }

    // 检查注册功能---成功注册
    public void regSuccess() throws IOException {
        driver.findElement(By.cssSelector("#phone-input")).clear();
        driver.findElement(By.cssSelector("#code-input")).clear();
        driver.findElement(By.cssSelector("#pass-input")).clear();
        driver.findElement(By.cssSelector("#again-pass-input")).clear();

        driver.findElement(By.cssSelector("#phone-input")).sendKeys("19898126695");
        driver.findElement(By.cssSelector("#code-button")).click();
        String code = new Scanner(System.in).nextLine();
        driver.findElement(By.cssSelector("#code-input")).sendKeys(code);
        driver.findElement(By.cssSelector("#pass-input")).sendKeys("121");
        driver.findElement(By.cssSelector("#again-pass-input")).sendKeys("121");
        driver.findElement(By.cssSelector("#reg-button")).click();

        // 找首页的元素检查是否注册成功
        driver.findElement(By.cssSelector("#login-button"));

        // 页面标题来检查是否注册成功
        String expect = driver.getCurrentUrl();
        assert expect.equals("http://localhost:11000/user/login");

        getScreenShot(getClass().getName());
    }

    // 检查注册功能---注册失败 输入框都为空
    public void regFailNullInput() throws IOException {
        driver.findElement(By.cssSelector("#phone-input")).clear();
        driver.findElement(By.cssSelector("#code-input")).clear();
        driver.findElement(By.cssSelector("#pass-input")).clear();
        driver.findElement(By.cssSelector("#again-pass-input")).clear();

        // 找首页的元素检查是否注册失败
        driver.findElement(By.cssSelector("#reg-button"));

        // 页面标题来检查是否注册失败
        String expect = driver.getCurrentUrl();
        assert expect.equals("http://localhost:11000/user/register");

        getScreenShot(getClass().getName());
    }

    // 检查注册功能---注册失败 两次密码不一致
    public void regFailPassFail() throws IOException {
        driver.findElement(By.cssSelector("#phone-input")).clear();
        driver.findElement(By.cssSelector("#code-input")).clear();
        driver.findElement(By.cssSelector("#pass-input")).clear();
        driver.findElement(By.cssSelector("#again-pass-input")).clear();

        driver.findElement(By.cssSelector("#phone-input")).sendKeys("19898126695");
        driver.findElement(By.cssSelector("#code-input")).sendKeys("123456");
        driver.findElement(By.cssSelector("#pass-input")).sendKeys("121");
        driver.findElement(By.cssSelector("#again-pass-input")).sendKeys("111");
        driver.findElement(By.cssSelector("#reg-button")).click();

        // 找首页的元素检查是否注册失败
        driver.findElement(By.cssSelector("#reg-button"));

        // 页面标题来检查是否注册失败
        String expect = driver.getCurrentUrl();
        assert expect.equals("http://localhost:11000/user/register");

        getScreenShot(getClass().getName());
    }

    // 检查注册功能---注册失败 验证码错误
    public void regFailCodeFail() throws IOException {
        driver.findElement(By.cssSelector("#phone-input")).clear();
        driver.findElement(By.cssSelector("#code-input")).clear();
        driver.findElement(By.cssSelector("#pass-input")).clear();
        driver.findElement(By.cssSelector("#again-pass-input")).clear();

        driver.findElement(By.cssSelector("#phone-input")).sendKeys("19898126695");
        driver.findElement(By.cssSelector("#code-input")).sendKeys("123456");
        driver.findElement(By.cssSelector("#pass-input")).sendKeys("121");
        driver.findElement(By.cssSelector("#again-pass-input")).sendKeys("121");
        driver.findElement(By.cssSelector("#reg-button")).click();

        // 找首页的元素检查是否注册失败
        driver.findElement(By.cssSelector("#reg-button"));

        // 页面标题来检查是否注册失败
        String expect = driver.getCurrentUrl();
        assert expect.equals("http://localhost:11000/user/register");

        getScreenShot(getClass().getName());
    }
}

import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Scanner;

public class UserLogin extends Utils {

    public UserLogin(String url) {
        super(url);
    }

    // 检查页面是否加载成功
    public void loginPageRight() throws InterruptedException, IOException {
        //通过查看页面元素是否存在来检查页面加载成功与否
        driver.findElement(By.cssSelector("#phone-input"));
    }

    // 检查密码登录功能---成功登录
    public void passLoginSuccess() throws IOException {
        driver.findElement(By.cssSelector("#phone-input")).clear();
        driver.findElement(By.cssSelector("#pass-input")).clear();

        driver.findElement(By.cssSelector("#phone-input")).sendKeys("15889835718");
        driver.findElement(By.cssSelector("#pass-input")).sendKeys("121");
        driver.findElement(By.cssSelector("#login-button")).click();

        // 找首页的元素检查是否登录成功
        driver.findElement(By.cssSelector("#loginUserNickname"));

        // 页面标题来检查是否登陆成功
        String expect = driver.getCurrentUrl();
        assert expect.equals("http://localhost:11000/user/main");

        getScreenShot(getClass().getName());
    }

    // 检查验证码登录功能---成功登录
    public void codeLoginSuccess() throws IOException {
        driver.get("http://localhost:11000/user/login");
        driver.findElement(By.cssSelector("#app > div > div > div.switch > button.el-button.is-text.switch-code")).click();

        driver.findElement(By.cssSelector("#phone-input")).clear();
        driver.findElement(By.cssSelector("#code-input")).clear();

        driver.findElement(By.cssSelector("#phone-input")).sendKeys("15889835718");
        driver.findElement(By.cssSelector("#code-button")).click();
        String code = new Scanner(System.in).nextLine();
        driver.findElement(By.cssSelector("#code-input")).sendKeys(code);
        driver.findElement(By.cssSelector("#login-button")).click();

        // 找首页的元素检查是否登录成功
        driver.findElement(By.cssSelector("#loginUserNickname"));

        // 页面标题来检查是否登陆成功
        String expect = driver.getCurrentUrl();
        assert expect.equals("http://localhost:11000/user/main");

        getScreenShot(getClass().getName());

        driver.navigate().back();
    }

    // 检查密码登录功能---登录失败 手机号/密码错误
    public void passLoginFail() throws IOException {
        driver.findElement(By.cssSelector("#phone-input")).clear();
        driver.findElement(By.cssSelector("#pass-input")).clear();

        driver.findElement(By.cssSelector("#phone-input")).sendKeys("15889835718");
        driver.findElement(By.cssSelector("#pass-input")).sendKeys("1");
        driver.findElement(By.cssSelector("#login-button")).click();

        // 找首页的元素检查是否登录失败
        driver.findElement(By.cssSelector("#phone-input"));

        // 页面标题来检查是否登陆成功
        String expect = driver.getCurrentUrl();
        assert expect.equals("http://localhost:11000/user/login");

        getScreenShot(getClass().getName());
    }

    // 检查验证码登录功能---登录失败 手机号/验证码错误
    public void codeLoginFail() throws IOException {
        driver.findElement(By.cssSelector("#app > div > div > div.switch > button.el-button.is-text.switch-code")).click();

        driver.findElement(By.cssSelector("#phone-input")).clear();
        driver.findElement(By.cssSelector("#code-input")).clear();
        driver.findElement(By.cssSelector("#phone-input")).sendKeys("15889835718");
        driver.findElement(By.cssSelector("#code-input")).sendKeys("123456");
        driver.findElement(By.cssSelector("#login-button")).click();

        // 找首页的元素检查是否登录失败
        driver.findElement(By.cssSelector("#phone-input"));

        // 页面标题来检查是否登陆成功
        String expect = driver.getCurrentUrl();
        assert expect.equals("http://localhost:11000/user/login");

        getScreenShot(getClass().getName());
    }
}

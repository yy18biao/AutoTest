import org.openqa.selenium.By;

import java.io.IOException;

public class UserUpdate extends Utils{
    public UserUpdate(String url) {
        super(url);
    }

    // 检查页面是否加载成功
    public void loginPageRight() throws InterruptedException, IOException {
        //通过查看页面元素是否存在来检查页面加载成功与否
        driver.findElement(By.cssSelector("#update-nickname"));
    }


}

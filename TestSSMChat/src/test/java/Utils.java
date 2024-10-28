import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class Utils {
    public static ChromeDriver driver;

    public Utils(String url){
        ChromeDriver driver = create();
        driver.get(url);
    }

    // 创建驱动对象
    public static ChromeDriver create(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            //允许访问所有的链接
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
            // 隐式等待
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    // 获取屏幕截图
    public void getScreenShot(String str) throws IOException{
        String filename = "./src/test/java/screenshot/" + new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis()) +
                "/" + str + "_" + new SimpleDateFormat("HHmmss").format(System.currentTimeMillis()) + ".png";
        File srcfile = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcfile,new File(filename));
    }
}

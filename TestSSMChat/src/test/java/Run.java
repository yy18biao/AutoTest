import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException, InterruptedException {
        userLogin();
    }

    private static void userLogin() throws IOException, InterruptedException {
        UserLogin userLogin = new UserLogin("http://localhost:11000/");
        userLogin.loginPageRight();
        userLogin.passLoginFail();
        userLogin.codeLoginFail();
        userLogin.codeLoginSuccess();
        userLogin.passLoginSuccess();
    }

    private static void userReg() throws IOException, InterruptedException {
        UserReg userReg = new UserReg("http://localhost:11000/");
        Thread.sleep(1000);
        userReg.regPageRight();
        userReg.regFailNullInput();
        Thread.sleep(1000);
        userReg.regFailPassFail();
        Thread.sleep(1000);
        userReg.regFailCodeFail();
        Thread.sleep(1000);
        userReg.regSuccess();
    }
}

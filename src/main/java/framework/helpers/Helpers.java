package framework.helpers;

import java.io.File;
import com.github.javafaker.Faker;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import framework.pages.BasePage;

public class Helpers {

    @SneakyThrows
    public static void makeScreenShot() {
        File scrFile = ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,
                new File("/Users/olegdatsiuk/IdeaProjects/pageObjectLab/src/test/resources/sreenshots/"
                        + new Faker().random().hex(10) + ".png"));
    }


    @Attachment(value = "{fileName}", type = "image/png")
    public static byte[] takeScreenShot(String fileName) {
        return ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.BYTES);
    }


}

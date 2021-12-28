package steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static logger.CustomLogger.logger;

public class ActionsWithOurWebElements {

    @Step
    public void clickElement(String text) {
        $(byXpath("//a[text()='" + text + "']")).click();
        logger.info(text + " - ok");
    }

}

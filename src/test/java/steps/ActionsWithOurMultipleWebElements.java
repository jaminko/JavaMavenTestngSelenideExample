package steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static logger.CustomLogger.logger;

public class ActionsWithOurMultipleWebElements {
    @Step
    public void clickElement(String text, int index) {
        $(byXpath("(//a[text()='" + text + "'])[" + index + "]")).click();
        logger.info(text + " - ok");
    }
}

package tests;

import test_data.Links;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.open;

public class WikipediaClickableElements extends BasePage {

    @BeforeMethod(alwaysRun = true)
    public void openMainPage() {
        open(Links.WIKIPEDIA_MAIN_PAGE.getUrl());
    }

    @Test
    public void checkClickableElements() {
        mainPage.pressButtonWithLanguage("RU");
        actionsWithOurWebElements.clickElement("Заглавная страница");
        actionsWithOurWebElements.clickElement("Рубрикация");
        actionsWithOurWebElements.clickElement("Форум");
        actionsWithOurWebElements.clickElement("История");
        actionsWithOurMultipleWebElements.clickElement("Обсуждение", 2);
    }

}

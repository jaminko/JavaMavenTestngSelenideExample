package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import test_data.Links;

import static com.codeborne.selenide.Selenide.open;
import static steps.CommonSteps.checkUrl;

public class WikipediaLanguages extends BasePage {

    @DataProvider
    public Object[] languageCodes() {
        return new Object[]{
                "EN", "JA", "RU", "IT", "PT", "ES", "DE", "ZH", "FR", "PL"
        };
    }

    @BeforeMethod(alwaysRun = true)
    public void openMainPage() {
        open(Links.WIKIPEDIA_MAIN_PAGE.getUrl());
    }
//test
    @Test
    public void checkLanguageEnglish() {
        mainPage.pressButtonWithLanguageEnglish();
        checkUrl("/wiki/Main_Page", 5);
    }

    @Test(dataProvider = "languageCodes")
    public void checkAllLanguages(String languageCode) {
        mainPage.pressButtonWithLanguage(languageCode);
        checkUrl("https://" + languageCode.toLowerCase() + ".wikipedia.org/wiki/", 5);
    }

}

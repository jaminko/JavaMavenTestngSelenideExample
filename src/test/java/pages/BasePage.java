package pages;

import runners.SelenoidRunner;
import steps.ActionsWithOurMultipleWebElements;
import steps.ActionsWithOurWebElements;

public class BasePage extends SelenoidRunner {
    public MainPage mainPage = new MainPage();
    public ActionsWithOurWebElements actionsWithOurWebElements = new ActionsWithOurWebElements();
    public ActionsWithOurMultipleWebElements actionsWithOurMultipleWebElements =
            new ActionsWithOurMultipleWebElements();
}

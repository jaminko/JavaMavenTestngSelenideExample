package test_data;

public enum Links {
    WIKIPEDIA_MAIN_PAGE("https://www.wikipedia.org/");

    private final String url;

    Links(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}

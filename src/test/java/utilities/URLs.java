package utilities;

public enum URLs {
    BASE_URL("https://www.infometis.ch/"),
    JOB_PAGE(BASE_URL.url + "/infometen?category=Jobs");

    private final String url;

    URLs(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url;
    }
} 
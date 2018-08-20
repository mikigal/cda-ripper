package pl.mikigal.cda.type;

public enum QualityType {

    P360("360p"),
    P480("480p"),
    P720("720p"),
    P1080("1080p");

    private final String name;

    QualityType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
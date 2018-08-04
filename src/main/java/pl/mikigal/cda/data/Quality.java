package pl.mikigal.cda.data;

public enum Quality {
    P360("360p"),
    P480("480p"),
    P720("720p"),
    P1080("1080p");

    private final String name;

    Quality(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

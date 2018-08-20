package pl.mikigal.cda.entity;

import javax.persistence.*;

@Entity
@Table(name = "downloads")
public class DownloadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String ip;
    private String video;

    public DownloadEntity() {
        //Constructor for JPA
    }

    public DownloadEntity(String date, String ip, String video) {
        this.date = date;
        this.ip = ip;
        this.video = video;
    }

    public int getId() {
        return this.id;
    }

    public String getDate() {
        return this.date;
    }

    public String getIp() {
        return this.ip;
    }

    public String getVideo() {
        return this.video;
    }

}
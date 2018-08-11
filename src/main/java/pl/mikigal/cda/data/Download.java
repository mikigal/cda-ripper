package pl.mikigal.cda.data;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
@Entity
@Table(name = "downloads")
public class Download {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String date;
    private String ip;
    private String video;

    public Download() {

    }

    public Download(String date, String ip, String video) {
        this.date = date;
        this.ip = ip;
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getIp() {
        return ip;
    }

    public String getVideo() {
        return video;
    }
}

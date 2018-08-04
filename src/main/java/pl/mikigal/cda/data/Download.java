package pl.mikigal.cda.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Getter
@Setter

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
    private String quality;
}

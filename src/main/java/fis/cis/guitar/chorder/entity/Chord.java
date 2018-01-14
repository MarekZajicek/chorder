package fis.cis.guitar.chorder.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "chord")
public class Chord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ElementCollection
    @Column(nullable = false)
    private Map<GuitarString, Integer> fingers;

    @Column(nullable = false, name = "barre_position")
    private Integer barrePosition;

    @Column(nullable = false, name = "real_barre_position")
    private Integer realBarrePositon;

    @Column(nullable = false, length = 10000)
    private byte[] blobImg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<GuitarString, Integer> getFingers() {
        return fingers;
    }

    public void setFingers(Map<GuitarString, Integer> fingers) {
        this.fingers = fingers;
    }

    public Integer getBarrePosition() {
        return barrePosition;
    }

    public void setBarrePosition(Integer barrePosition) {
        this.barrePosition = barrePosition;
    }

    public Integer getRealBarrePositon() {
        return realBarrePositon;
    }

    public void setRealBarrePositon(Integer realBarrePositon) {
        this.realBarrePositon = realBarrePositon;
    }

    public byte[] getBlobImg() {
        return blobImg;
    }

    public void setBlobImg(byte[] blobImg) {
        this.blobImg = blobImg;
    }
}

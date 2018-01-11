package fis.cis.guitar.chorder.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "string")
public class GuitarString {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String alternativeName;

    @Column(nullable = false)
    private String smallCapsName;

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

    public String getAlternativeName() {
        return alternativeName;
    }

    public void setAlternativeName(String alternativeName) {
        this.alternativeName = alternativeName;
    }

    public String getSmallCapsName() {
        return smallCapsName;
    }

    public void setSmallCapsName(String smallCapsName) {
        this.smallCapsName = smallCapsName;
    }

    @Override
    public int hashCode() {
        return id.hashCode() + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return ((GuitarString) obj).id == id;
    }
}

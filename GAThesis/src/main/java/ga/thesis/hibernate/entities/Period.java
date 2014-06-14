package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by sky_lady on 6/14/14.
 */
@Entity
@Table(name="Period")
public class Period implements Serializable {
    private static final long serialVersionUID = -5170875020617735654L; //?

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "period", nullable = false)
    private String period;

    @Column(name = "dayOfTheWek", nullable = false)
    private Integer dayOfTheWek;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "period", nullable = false)
    public String getPeriod() {
        return period;
    }


    public void setPeriod(String period) {
        this.period = period;
    }

    @Column(name = "dayOfTheWek", nullable = false)
    public Integer getDayOfTheWek() {
        return dayOfTheWek;
    }

    public void setDayOfTheWek(Integer dayOfTheWek) {
        this.dayOfTheWek = dayOfTheWek;
    }
}

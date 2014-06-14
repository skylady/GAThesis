package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky_lady on 6/14/14.
 */
@Entity
@Table(name = "AbsencePeriod")
public class AbsenceMatrix implements Serializable {
    private static final long serialVersionUID = -5170875020617735651L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

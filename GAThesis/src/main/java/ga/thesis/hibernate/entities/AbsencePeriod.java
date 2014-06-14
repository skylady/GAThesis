package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky_lady on 6/14/14.
 */
@Entity
@Table(name = "AbsencePeriod")
public class AbsencePeriod implements Serializable {
    private static final long serialVersionUID = -5170875020617735659L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @OneToOne
    @JoinColumn(name = "Period", nullable = false)
    private Period idPeriod;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "Period", nullable = false)
    public Period getIdPeriod() {
        return idPeriod;
    }

    public void setIdPeriod(Period idPeriod) {
        this.idPeriod = idPeriod;
    }
}

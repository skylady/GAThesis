package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky_lady on 6/14/14.
 */
@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable {
    private static final long serialVersionUID = -5170875020617735673L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToOne
    @JoinColumn(name = "AbsenceMatrix")
    private AbsenceMatrix idAbsenceMatrix;

    public AbsenceMatrix getIdAbsenceMatrix() {
        return idAbsenceMatrix;
    }

    public void setIdAbsenceMatrix(AbsenceMatrix idAbsenceMatrix) {
        this.idAbsenceMatrix = idAbsenceMatrix;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

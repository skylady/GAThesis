package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky_lady on 6/14/14.
 */
@Entity
@Table(name = "GroupList")
public class GroupList implements Serializable {
    private static final long serialVersionUID = -5170875020617735657L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

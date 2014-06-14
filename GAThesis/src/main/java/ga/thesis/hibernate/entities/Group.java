package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky_lady on 6/14/14.
 */
@Entity
@Table(name = "Group")
public class Group implements Serializable{
    private static final long serialVersionUID = -5170875020617735673L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "group_number", nullable = false)
    private String groupNumber;

    @OneToOne
    @JoinColumn(name = "GroupCode")
    private GroupCode idGroupCode;

    public GroupCode getIdGroupCode() {
        return idGroupCode;
    }

    public void setIdGroupCode(GroupCode idGroupCode) {
        this.idGroupCode = idGroupCode;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

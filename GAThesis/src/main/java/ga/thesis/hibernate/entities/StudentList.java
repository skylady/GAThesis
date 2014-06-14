package ga.thesis.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sky_lady on 6/14/14.
 */

@Entity
@Table(name="StudentList")
public class StudentList implements Serializable {
    private static final long serialVersionUID = -5170875020617735656L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column (name = "student",nullable=false)
    private String auditoryNumber;

    @ManyToOne
    @JoinColumn(name = "GroupList")
    private GroupList groupListId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GroupList getGroupListId() {
        return groupListId;
    }

    public void setGroupListId(GroupList groupListId) {
        this.groupListId = groupListId;
    }

    public String getAuditoryNumber() {
        return auditoryNumber;
    }

    public void setAuditoryNumber(String auditoryNumber) {
        this.auditoryNumber = auditoryNumber;
    }
}

package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_group")
public class Group {

    @Id // tao primakey id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // tu dong tang

    @Column(name = "ID")
    private Integer id;

    @Column(name = "GroupName", nullable = false, unique = true )
    private String groupName;


    @Temporal(TemporalType.DATE)
    @Column(name = "CreatedDate")
    private Date createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Group" +id+": "+
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}

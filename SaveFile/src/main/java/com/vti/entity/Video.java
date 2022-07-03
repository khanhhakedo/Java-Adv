package com.vti.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Video")
@Data
public class Video implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VideoID")
    private  Integer id;

    @Column(name = "VideoName", nullable = false, length = 50)
    private String videoname;

    @Column(name = "Title", nullable = false, length = 100)
    private String title;

    @Column(name = "Description", nullable = false, length = 50)
    private  String description;


    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category categoryVideo;

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", videoname='" + videoname + '\'' + "\n"+
                ", title='" + title + '\'' +"\n"+
                ", description='" + description + '\'' +"\n"+
                ", categoryVideo=" + categoryVideo +"\n"+
                '}';
    }
}

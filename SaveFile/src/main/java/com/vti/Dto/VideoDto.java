package com.vti.Dto;

import com.vti.entity.Category;
import lombok.Data;

import javax.persistence.*;

@Data
public class VideoDto {

    private  Integer id;

    private String videoname;

    private String title;

    private  String description;

    private Category categoryVideo;
}

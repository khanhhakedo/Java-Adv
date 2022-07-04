package com.vti.service;


import com.vti.entity.Video;

import java.util.List;

public interface VideoService {
    public List<Video> getAll();
    public List<Video> getByName(String videoName);
    public List<Video> getById(Integer id);

    public void save(Video video);

    public void update(Video video);

    public void delete(Integer id);
}

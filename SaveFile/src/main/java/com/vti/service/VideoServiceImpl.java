package com.vti.service;

import com.vti.entity.Video;
import com.vti.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
   @Autowired
   private VideoRepository videoRepository;


    @Override
    public List<Video> getAll() {
        return videoRepository.findAll();
    }

    @Override
    public List<Video> getByName(String videoName) {
        List<Video> videoList = videoRepository.findByVideoname(videoName);
        return videoList;
    }

    @Override
    public void save(Video video) {
        videoRepository.save(video);

    }

    @Override
    public void update(Video video) {
        videoRepository.save(video);

    }

    @Override
    public void delete(Integer id) {
        Video video = videoRepository.findById(id).get();
        videoRepository.delete(video);

    }
}

package com.vti.controller;


import com.vti.entity.Video;
import com.vti.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping()
    public List<Video> getAllVides() {
        return videoService.getAll();
    }

    @GetMapping("list")
    public List<Video> getAll(@RequestParam("videoName") String videoName){
        List<Video> videos= videoService.getByName(videoName);
        return videos;
    }

    @PostMapping()
    public void createVideo(@RequestBody Video video) {
        videoService.save(video);
    }

    @PutMapping(value = "/{id}")
    public void updateVideo(@PathVariable(name = "id") Integer id, @RequestBody Video video) {
        video.setId(id);
        videoService.update(video);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteVideo(@PathVariable(name = "id") Integer id) {
        videoService.delete(id);
    }
}

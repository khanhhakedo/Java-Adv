package com.vti.controller;



import com.vti.Dto.VideoDto;
import com.vti.entity.Video;
import com.vti.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

//    @GetMapping()
//    public List<Video> getAllVides() {
//        return videoService.getAll();
//    }

    //Chuyển đổi DTO
    @GetMapping()
    public ResponseEntity<?> getAllVideos() {
        List<Video> videos = videoService.getAll();
        List<VideoDto> videoDtos = new ArrayList<>();
        for (Video video : videos){
            VideoDto videoDto = new VideoDto();
            videoDto.setId(video.getId());
            videoDto.setVideoname(video.getVideoname());
            videoDto.setTitle(video.getTitle());
            videoDto.setDescription(video.getDescription());
            videoDto.setCategoryVideo(video.getCategoryVideo());

            videoDtos.add(videoDto);

        }
        return new ResponseEntity<>(videoDtos, HttpStatus.OK);
    }

    @GetMapping("listname")
    public List<Video> getAll(@RequestParam("videoName") String videoName){
        List<Video> videos= videoService.getByName(videoName);
        return videos;
    }

    @GetMapping("listid")
    public List<Video> getAll(@RequestParam("id") Integer id){
        List<Video> videos= videoService.getById(id);
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

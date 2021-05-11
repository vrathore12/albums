package com.albums.resources;

import com.albums.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.albums.services.AlbumService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/albums")
    public List<Album> getAlbums(){
        return albumService.getAlbums();
    }

    @GetMapping("/albums/{albumId}")
    public Album getAlbum(@PathVariable("albumId")int albumId){
        return albumService.getAlbum(albumId);
    }

    @PostMapping("/albums")
    public Album addAlbum(@RequestBody Album album){
        return albumService.addAlbum(album);
    }

    @PutMapping("/albums/{albumId}")
    public Album updateAlbum(@PathVariable("albumId")int albumId, @RequestBody Album album){
        return albumService.updateAlbum(albumId, album);
    }

    @DeleteMapping("/album")
    public Album deleteAlbum(@RequestParam(name="albumId") int albumId){
        return albumService.deleteAlbum(albumId);
    }
}

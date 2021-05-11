package com.albums.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.albums.repository.AlbumRepository;
import java.util.List;
import com.albums.model.Album;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;


    public List<Album> getAlbums() {
        return albumRepository.getAlbums();
    }

    public Album getAlbum(int albumId) {
        return albumRepository.getAlbum(albumId);
    }

    public Album addAlbum(Album album) {
        return albumRepository.addAlbum(album);
    }

    public Album updateAlbum(int albumId, Album album) {
        return albumRepository.updateAlbum(albumId, album);
    }

    public Album deleteAlbum(int albumId) {
        return albumRepository.deleteAlbum(albumId);
    }
}

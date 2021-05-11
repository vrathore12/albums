package com.albums.repository;

import com.albums.model.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {

    List<Album> albumList = new ArrayList();

    public List<Album> getAlbums() {
//        Album album1 = new Album("Adam's World Tour","The time when Adam went on a trip around the world","https://source.unsplash.com/user/erondu");
//        return album1;
        return albumList;
    }

    public Album getAlbum(int albumId) {
        for (Album a : albumList) {
            if (a.getAlbumId() == albumId)
                return a;
        }
        return null;
    }

    public Album addAlbum(Album album) {
        if (albumList.isEmpty())
            album.setAlbumId(albumList.size() + 1);
        else {
            Album lastAlbumInList = albumList.get(albumList.size() - 1);
            album.setAlbumId(lastAlbumInList.getAlbumId() + 1); /*This is to maintain the flow of index
            numbers even if something is deleted from the middle of the list*/
        }
        albumList.add(album);
        return album;
    }


    public Album updateAlbum(int albumId, Album album) {
        for (Album a : albumList) {
            if (a.getAlbumId() == albumId) {
                a.setName(album.getName());
                a.setDescription(album.getDescription());
                a.setCoverPicUrl(album.getCoverPicUrl());
                return a;
            }
        }
        return null;
    }


    public Album deleteAlbum(int albumId) {
        Album deletedAlbum = null;
        for (Album a : albumList) {
            if (a.getAlbumId() == albumId) {
                deletedAlbum = a;
                albumList.remove(a);
                return deletedAlbum;
            }
        }
        return deletedAlbum;
    }
}

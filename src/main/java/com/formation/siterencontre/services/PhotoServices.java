package com.formation.siterencontre.services;

import com.formation.siterencontre.entities.Photo;
import com.formation.siterencontre.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PhotoServices {

    private PhotoRepository pr;

    @Autowired
    public PhotoServices(PhotoRepository pr) {
        this.pr = pr;
    }

    public void create(Photo photo){ pr.save(photo);   }

    public ArrayList<Photo> getAllPhoto(){  return  (ArrayList<Photo>) pr.findAll(); }

    public Photo findById (long id){return  pr.findById(id).get(); }

    public void update(Photo photo){ pr.save(photo);  }

    public void delete (long id){   pr.deleteById(id); }

    public void deletAll (){ pr.deleteAll(); }

    public long taille(){
        return pr.count();
    }
}

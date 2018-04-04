package com.formation.siterencontre.services;

import com.formation.siterencontre.entities.Adresse;
import com.formation.siterencontre.entities.Adresse;
import com.formation.siterencontre.repositories.AdresseRepository;
import com.formation.siterencontre.repositories.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdresseServices {

    private AdresseRepository ar;

    @Autowired
    public AdresseServices(AdresseRepository ar) {
        this.ar = ar;
    }

    public void create(Adresse adresse){ ar.save(adresse);   }

    public ArrayList<Adresse> getAllAdresse(){  return  (ArrayList<Adresse>) ar.findAll(); }

    public Adresse findById (long id){return  ar.findById(id).get(); }

    public void update(Adresse adresse){ ar.save(adresse);  }

    public void delete (long id){   ar.deleteById(id); }

    public void deletAll (){ ar.deleteAll(); }

    public long taille(){
        return ar.count();
    }
}

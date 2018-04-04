package com.formation.siterencontre.services;

import com.formation.siterencontre.entities.CentreInteret;
import com.formation.siterencontre.repositories.CentreInteretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CentreInteretServices {

    private CentreInteretRepository cr;

    @Autowired
    public CentreInteretServices(CentreInteretRepository cr) {
        this.cr = cr;
    }

    public void create(CentreInteret centreIntert){ cr.save(centreIntert);   }

    public ArrayList<CentreInteret> getAllCentreInteret(){  return  (ArrayList<CentreInteret>) cr.findAll(); }

    public CentreInteret findById (long id){return  cr.findById(id).get(); }

    public void update(CentreInteret centreIntert){ cr.save(centreIntert);  }

    public void delete (long id){   cr.deleteById(id); }

    public void deletAll (){ cr.deleteAll(); }

    public long taille(){
        return cr.count();
    }
}

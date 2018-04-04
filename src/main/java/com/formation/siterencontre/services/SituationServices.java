package com.formation.siterencontre.services;

import com.formation.siterencontre.entities.Situation;
import com.formation.siterencontre.repositories.SituationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SituationServices {

    private SituationRepository sr;

    @Autowired
    public SituationServices(SituationRepository sr) {
        this.sr = sr;
    }

    public void create(Situation situation){ sr.save(situation);   }

    public ArrayList<Situation> getAllSituation(){  return  (ArrayList<Situation>) sr.findAll(); }

    public Situation findById (long id){return (Situation) sr.findById(id).get(); }

    public void update(Situation situation){ sr.save(situation);  }

    public void delete (long id){   sr.deleteById(id); }

    public void deletAll (){ sr.deleteAll(); }

    public long taille(){
        return sr.count();
    }
}

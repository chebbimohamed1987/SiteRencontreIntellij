package com.formation.siterencontre.services;

import com.formation.siterencontre.entities.Apparence;
import com.formation.siterencontre.repositories.ApparenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ApparenceServices {

    private ApparenceRepository apr;

    @Autowired
    public ApparenceServices(ApparenceRepository apr) {
        this.apr = apr;
    }

    public void create(Apparence apparence){ apr.save(apparence);   }

    public ArrayList<Apparence> getAllApparence(){  return  (ArrayList<Apparence>) apr.findAll(); }

    public Apparence findById (long id){return  apr.findById(id).get(); }

    public void update(Apparence apparence){ apr.save(apparence);  }

    public void delete (long id){   apr.deleteById(id); }

    public void deletAll (){ apr.deleteAll(); }

    public long taille(){
        return apr.count();
    }
}

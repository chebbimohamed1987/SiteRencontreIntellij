package com.formation.siterencontre.services;

import com.formation.siterencontre.entities.Utilisateur;
import com.formation.siterencontre.enums.Sexe;
import com.formation.siterencontre.repositories.UtilisateurRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest//(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UtilisateurServicesTest {

    @Before
    public Utilisateur init() throws Exception {

       return  new Utilisateur("mohamed.chebbi@cpe.fr", "chebbi", "mohamed", "2018-04-10", Sexe.F, "sdfsfsdfdsD544+", "hellotoutlemonde", "mohamed0845", "0615847521", 0);

    }

    @Autowired
    private UtilisateurServices us;

    @Test
    public void create() {
    }

    @Test
    public void getAllUtilisateur() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void deletAll() {
    }

    @Test
    public void taille() {
    }

    @Test
    public void findUtilisateurByEmail() {

        String mail = "mohamed.chebbi@viacesi.fr";
        String mail2 = "wwwww@viacesi.fr";
        Utilisateur user = us.findUtilisateurByEmail(mail);
        Assert.assertNotNull(user);

        Assert.assertEquals(user.getEmailUtilisateur(), mail);
        Assert.assertNotEquals(user.getEmailUtilisateur(), mail2);
    }

    @Test
    public void findUtilisateurByEmailUtilisateurEtMotDePasse() {
    }

    @Test
    public void create1() {
    }

    @Test
    public void getAllUtilisateur1() {
    }

    @Test
    public void findUtilisateurByEmail1() {
    }
}
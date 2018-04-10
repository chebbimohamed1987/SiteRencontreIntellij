package com.formation.siterencontre.controllers;

import com.formation.siterencontre.entities.Utilisateur;
import com.formation.siterencontre.enums.Fumeur;
import com.formation.siterencontre.services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(UtilisateurController.class)

public class UtilisateurControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    private UtilisateurServices us;
    @MockBean
    private AdresseServices as;
    @MockBean
    private ApparenceServices aps;
    @MockBean
    private SituationServices ss;
    @MockBean
    private CentreInteretServices cs;
    @MockBean
    private PhotoServices ps;


    @Test
    public void getFormulaire() throws Exception {

        /*String[] t = {"jamais", "occasionnellement", "regulierement"};*/

        this.mvc.perform(get("/getformulaire"))

                .andExpect(view().name("inscription"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(model().attributeExists("utilisateur", "adresse", "apparence"))
                .andExpect(model().attributeExists("centreInterets"))
                .andExpect(model().attributeExists("situation"))
                .andExpect(model().attribute("fumeur", Fumeur.values()))
                .andExpect(model().size(6))
                .andExpect(content().string(containsString("Inscription")));

    }

    @Test
    public void getProfil() {
    }

    @Test
    public void getProfils() throws Exception {
        /* ArrayList<Utilisateur> utilisateurs = us.getAllUtilisateur();
         */
        this.mvc.perform(get("/getProfils"))
                .andExpect(view().name("profils"))
                /*  .andExpect(forwardedUrl("profils.html"))*/

                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
           /*     .andExpect(model().attribute("utilisateurs", utilisateurs))
                .andExpect(model().size(1))
                .andExpect(flash().attributeCount(0))*/

            /*    .andExpect(content().string(containsString("alpha")));*/


    }

    @Test
    public void getConexion() {
    }

    @Test
    public void session() {
    }
}
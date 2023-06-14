package edu.wat.tim.lab1.controller;

import org.graalvm.polyglot.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
public class ScriptController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/execute")
    @Transactional
    public String executeScript(@RequestBody String script) {
        Context context = Context.create();
        try {
            // Wykonaj skrypt
            context.eval("js", script);

            // Zmiana cyfr 0 na litery 'O' w imionach i nazwiskach użytkowników
            entityManager.createNativeQuery("UPDATE User SET firstName = REPLACE(firstName, '0', 'O'), lastName = REPLACE(lastName, '0', 'O')")
                    .executeUpdate();

            return "Skrypt wykonany pomyślnie.";
        } catch (Exception e) {
            return "Błąd podczas wykonywania skryptu: " + e.getMessage();
        } finally {
            context.close();
        }
    }
}
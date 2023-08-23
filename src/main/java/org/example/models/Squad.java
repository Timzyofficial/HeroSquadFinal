package org.example.models;

import java.util.ArrayList;

public class Squad {
    private static int nextId = 1;
    private int maxSize;
    private String name;
    private String cause;

    private int id;

    private ArrayList<Hero> heroes ;


    public int getMaxSize() {
        return maxSize;
    }

    public Squad(int maxSize, String name, String cause) {
        this.maxSize = maxSize;
        this.name = name;
        this.cause = cause;
        id = nextId++;

        heroes  = new ArrayList<>();
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addHero(Hero heroToAdd) {
        if(heroToAdd.getSquadId() != -1) {
            throw new IllegalArgumentException("This hero is already in a squad");
        }
        for(Hero hero: heroes) {
            if(hero.getId() == heroToAdd.getId()) {
                throw new IllegalArgumentException("You have already added this hero in this squad");
            }
        }

        heroes.add(heroToAdd);
        heroToAdd.setSquadId(this.id);
    }
}

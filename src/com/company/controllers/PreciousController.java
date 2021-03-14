package com.company.controllers;

import com.company.enteties.Precious;
import com.company.repositories.PreciousRepository;
import com.company.repositories.interfaces.IPreciousRepository;

import java.util.ArrayList;
import java.util.List;

public class PreciousController
{
    private final IPreciousRepository preciousRepository;

    public PreciousController(IPreciousRepository preciousRepository){
        this.preciousRepository = preciousRepository;
    }

    public String createPrecious(String name, int weight, int cost, boolean precious)
    {
        Precious stone = new Precious(name, weight, cost, precious);

        boolean created = preciousRepository.createPrecious(stone);

        return (created ? "Stone was created!" : "Stone creation was failed!");
    }

    public Precious getPrecious(int id) {
        Precious precious = preciousRepository.getPrecious(id);

        return precious;
    }

    public String getAllPrecious() {
        List<Precious> precious = preciousRepository.getAllPrecious();

        return precious.toString();
    }

    public String calculateNecklace(List<Precious> stones){
        Integer weight = 0;
        Integer cost = 0;
        for(int i=0;i<stones.size();i++){
            weight = weight + stones.get(i).getWeight();
            cost = cost + stones.get(i).getCost();
        }

        return "total weight: " + weight.toString() + " carats |  total cost: " + cost.toString();
    }
}

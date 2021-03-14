package com.company.enteties;

public class Precious
{
    private int id;
    private String name;
    private int weight;
    private int cost;
    private boolean precious;

    public Precious() {
    }

    public Precious(String name, int weight, int cost, boolean precious) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.precious = precious;
    }

    public Precious(int id, String name, int weight, int cost, boolean precious) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.precious = precious;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isPrecious() {
        return precious;
    }

    public void setPrecious(boolean precious) {
        this.precious = precious;
    }

    @Override
    public String toString() {
        return "Precious{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                ", precious=" + precious +
                '}';
    }
}

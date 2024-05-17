/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author levy
 */
public class Champion {
    private int code;
    private String name;
    private Type type;
    private String shortDesc;
    private int winrate;
    private LocalDate releaseDate;
    private boolean isRanged;
    private double price;
    
    public Champion(int code, String name, Type type, String shortDesc, int winrate, LocalDate releaseDate,
            boolean isRanged, double price) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.shortDesc = shortDesc;
        this.winrate = winrate;
        this.releaseDate = releaseDate;
        this.isRanged = isRanged;
        this.price = price;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    public String getShortDesc() {
        return shortDesc;
    }
    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public int getWinrate() {
        return winrate;
    }
    public void setWinrate(int winrate) {
        this.winrate = winrate;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isRanged() {
        return isRanged;
    }
    public void setRanged(boolean isRanged) {
        this.isRanged = isRanged;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

import DAO.ChampionDAO;
import DAO.TypeDAO;

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

    public Champion(){};

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

    public void showChamp(int code) throws SQLException{
        ChampionDAO champDao = new ChampionDAO();
        TypeDAO tpDao = new TypeDAO();
        Champion champ = champDao.getChampion(code);
        System.out.println("Code:\t" + champ.getCode());
        System.out.println("Name:\t" + champ.getName());
        System.out.println("Short Description: " + champ.getShortDesc());
        System.out.println("Winrate:\t" + champ.getWinrate());
        System.out.println("Release Date:\t" + Date.valueOf(champ.getReleaseDate()));
        System.out.println("Is ranged?\t" + champ.isRanged());
        System.out.println("Price:\t" + champ.getPrice());
        System.out.println("Type:\t" + tpDao.getType(champ.getType().getId()).getRole());
    }

    public void showChamp() throws SQLException{
        TypeDAO tpDao = new TypeDAO();
        System.out.println("Code:\t" + this.getCode());
        System.out.println("Name:\t" + this.getName());
        System.out.println("Short Description: " + this.getShortDesc());
        System.out.println("Winrate:\t" + this.getWinrate());
        System.out.println("Release Date:\t" + Date.valueOf(this.getReleaseDate()));
        System.out.println("Is ranged?\t" + this.isRanged());
        System.out.println("Price:\t" + this.getPrice());
        System.out.println("Type:\t" + tpDao.getType(this.getType().getId()).getRole());
    }
}

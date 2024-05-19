/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


import java.time.LocalDate;

import DAO.BDUtil;
import DAO.ChampionDAO;
import DAO.TypeDAO;
import model.Champion;
import model.Type;

/**
 *
 * @author levy
 */
public class Main {
    public static void main(String[] args) {
        try {
            //BDUtil.createDatabaseStructure(); //execute 1 time
            TypeDAO tpDao = new TypeDAO();
            ChampionDAO champDao = new ChampionDAO();

            LocalDate testDate2 = LocalDate.of(2012, 3, 4);

            Type testtype1 = new Type(2, "Mage");
            Champion testchamp1 = new Champion(2, "Ryze", testtype1, "Battlemage", 45, testDate2, true, 35.4);

            //tpDao.insertType(testtype1);
            //champDao.insertChampion(testchamp1);

            champDao.showChamps();
            champDao.showChampsByType(testtype1);
            champDao.getPriceByType();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

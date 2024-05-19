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
            BDUtil.clearTables();
            TypeDAO tpDao = new TypeDAO();
            ChampionDAO champDao = new ChampionDAO();

            LocalDate testDate2 = LocalDate.of(2012, 3, 4);

            Type mage = new Type(1, "Mage");
            Type marksman = new Type(2, "Marksman");
            Type tank = new Type(3, "Tank");
            Type bruiser = new Type(4, "Bruiser");
            Type support = new Type(5, "Support");


            Champion ryze = new Champion(1, "Ryze", mage, "Battlemage.", 45, testDate2, true, 35.4);
            Champion sion = new Champion(2, "Sion", tank, "Tank with infinite scaling.", 50, testDate2, false, 50.1);
            Champion twitch = new Champion(3, "Twitch", marksman, "Invisible marksman with great teamfight damage.", 50, testDate2, true, 70.6);
            Champion briar = new Champion(4, "Briar", bruiser, "Bruiser with berserk mechanic and global ultimate.", 50, testDate2, false, 100);
            Champion lulu = new Champion(5, "Lulu", support, "Shielding and buffing support.", 50, testDate2, true, 30);

            Champion deletedChampion = new Champion(6, "Test", mage, "Champion to test deleting.", 2, testDate2, false, 10);

            System.out.println("Inserted types: " + tpDao.insertType(mage));
            System.out.println("Inserted types: " + tpDao.insertType(marksman));
            System.out.println("Inserted types: " + tpDao.insertType(tank));
            System.out.println("Inserted types: " + tpDao.insertType(bruiser));
            System.out.println("Inserted types: " + tpDao.insertType(support));


            System.out.println("Inserted champions: " + champDao.insertChampion(ryze));
            System.out.println("Inserted champions: " + champDao.insertChampion(sion));
            System.out.println("Inserted champions: " + champDao.insertChampion(twitch));
            System.out.println("Inserted champions: " + champDao.insertChampion(briar));
            System.out.println("Inserted champions: " + champDao.insertChampion(lulu));
            System.out.println("Inserted champions: " + champDao.insertChampion(deletedChampion));

            ryze.setShortDesc("Battlemage with great scaling into the lategame.");
            System.out.println("Updated champions: " + champDao.updateChamp(ryze));

            System.out.println("Deleted champions: " + champDao.deleteChamp(6));

            champDao.showChamps();
            champDao.showChampsByType(mage);
            champDao.getPriceByType();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

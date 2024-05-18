/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import DAO.BDUtil;
import DAO.ChampionDAO;
import DAO.TypeDAO;
import model.Champion;

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

            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

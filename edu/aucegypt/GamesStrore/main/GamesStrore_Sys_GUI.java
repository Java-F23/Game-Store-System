package edu.aucegypt.GamesStrore.main;

import edu.aucegypt.GamesStrore.Helpers.Generator;
import edu.aucegypt.GamesStrore.guis.Activity_1;


public class GamesStrore_Sys_GUI 
{
    public static void main(String[] args) 
    {
        //Welcome Page
        Generator.playerGenerator();
        Generator.adminGenerator();
        Generator.gameGenrator();
        
        Activity_1.WelcomeMsg();
    }
}

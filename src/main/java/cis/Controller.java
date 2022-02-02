package cis;

import cis.entity.Bowling;
import cis.util.CisUtility;
import java.util.Scanner;

/**
 * Using arrays to create a bowling alley score keeping program
 *
 * @author OOL
 * @since 20220128
 */
public class Controller
{
    public static void main(String[] args)
    {
        Bowling bowling = new Bowling();
        
        bowling.addPlayers();
        bowling.addScores();
        bowling.announceWinner();
    }
}

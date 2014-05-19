/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhotdrawapp;
/**
 *
 * @author Yogayustiawan
 */
public class UsefulAction implements Runnable {
    //run untuk menjalankan tools jhotdraw
    public void run() {
        new UsefulHandler();
    }
}

package jhotdrawapp;

/**
 * Hello world!
 *
 */
import javax.swing.SwingUtilities;

final class App {
    
    public App(){
    }
   
    //make a color tool
    public void doSomething(){
            SwingUtilities.invokeLater((Runnable) new UsefulAction()); 
    }   
    
    public static void main(String[] args) {
        App app=new App();
        app.doSomething();
    }
    
}
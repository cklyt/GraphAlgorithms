/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso;

/**
 *
 * @author Aman
 */
public class App {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PSO optimization = new PSO();
        optimization.solve();
        optimization.showSoluction();
    }
}

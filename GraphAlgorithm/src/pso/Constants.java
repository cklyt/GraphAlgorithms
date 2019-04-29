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
public class Constants {

    public static int MAX_ITERATIONS = 10000;
    
    private Constants(){}
    
    public final static int NUM_DIMENSIONS =2;
    public final static int NUM_PARTICLES = 10;
    public final static double MIN = -2;
    public final static double MAX = 2;
    public final static double w = 0.729;
    public final static double c1 =1.49;
    public final static double c2 = 1.49;
    
    public final static double f(double[] data){
        return Math.exp(-data[0]*data[0]-data[1]*data[1])*Math.sin(data[0]);
    }
}

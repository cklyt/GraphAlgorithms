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

    public static int MAX_ITERATIONS = 1000;
    
    private Constants(){}
    
    public final static int NUM_DIMENSIONS =2;
    public final static int NUM_PARTICLES = 10; //the number of particles in the swarm
    public final static double MIN = -5;
    public final static double MAX = 5;
    public final static double w = 0.729;   //inertia weight:define the memory of the system. how significant is the last step taking place.
    public final static double c1 =1.49;    //cognitive or local weight:defines the tendency to return to the particle's best previous position
    public final static double c2 = 1.49;   //social or global weight: defines the tendency to move towards the neighborhoods's best previous position.
    
    public final static double f(double[] data){
        return Math.exp(-data[0]*data[0]-data[1]*data[1])*Math.sin(data[0]);
    }
    public final static double Griewank(double[] data)
        {
            int d = data.length;
            double sum = 0;
            double prod = 1f;
            for (int ii = 1; ii < d+1; ii++)
            {
                double xi = data[ii-1];
                sum = sum + xi *xi / 4000;
                prod = prod * Math.cos(xi / Math.sqrt(ii));
            }
            return sum - prod + 1;
        }
    public final static double Rastrigin(double[] data){
        int d = data.length;
        double sum = 0;
        for(int ii = 1;ii<d+1;ii++)
        {
            double xi = data[ii-1];
            sum = sum + (xi* xi - 10*Math.cos(2*Math.PI*xi));
        }
        return 10*d+sum;
        
    }
    public final static double DropWave(double[] data){
        double x1 = data[0];
        double x2 = data[1];
        double frac1 = 1 + Math.cos(12*Math.sqrt(x1*x1+x2*x2));
        double frac2 = 0.5 *(x1 * x1+x2* x2)+2;
        return -frac1/frac2;
    }
            
}

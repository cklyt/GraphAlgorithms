/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso;

import java.util.logging.Logger;

/**
 *
 * @author Aman
 */
public class Particle {
    private double[] position; //contains x and y
    private double[] velocity;
    private double[] bestPosition;
    public Particle(double[] position, double[] velocity){
        this.position = new double[Constants.NUM_DIMENSIONS];
        this.velocity = new double[Constants.NUM_DIMENSIONS];
        this.bestPosition = new double[Constants.NUM_DIMENSIONS];
        
        System.arraycopy(velocity, 0, this.velocity, 0, velocity.length);
        System.arraycopy(position, 0, this.position, 0, position.length);
    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public double[] getVelocity() {
        return velocity;
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    public double[] getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(double[] bestPosition) {
        this.bestPosition = bestPosition;
    }
    
    public void CheckBestSolution(double[] globalBestSolution){
        if(Constants.f(this.bestPosition)<Constants.f(globalBestSolution))
            globalBestSolution = this.bestPosition;
    }
    
    @Override
    public String toString() {
        return "Particle{" + "position=" + position + " best position so far: " + this.bestPosition[0] + " - "+ this.bestPosition[1] +'}';
    }
    

}

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
public class PSO {

    private double[] globalBestSolutions;
    private Particle[] particleSwarm;
    private int epochs;

    public PSO() {
        this.globalBestSolutions = new double[Constants.NUM_DIMENSIONS];
        this.particleSwarm = new Particle[Constants.NUM_PARTICLES];
        generateRandomSolution();
        
    }
   
    public void solve(){
        epochs = 0;
        for(int i =0; i<Constants.NUM_PARTICLES;++i){
            double[] locations = initializeLocation();
            double[] velocity = initializeVelocity();
            
            this.particleSwarm[i] = new Particle(locations , velocity);
        }
        
        while(epochs < Constants.MAX_ITERATIONS){
            for(Particle actualParticle : this.particleSwarm){
                //update velocity
                for(int i =0; i<actualParticle.getVelocity().length;++i){
                    double rp = Math.random();
                    double rg = Math.random();
                    
                    actualParticle.getVelocity()[i] = Constants.w*actualParticle.getVelocity()[i]+
                            Constants.c1*rp*(actualParticle.getBestPosition()[i] - actualParticle.getPosition()[i])
                            + Constants.c2 * rg *(this.globalBestSolutions[i]-actualParticle.getPosition()[i]);
                }
                
                //update position
                for(int i =0 ; i <actualParticle.getPosition().length;++i){
                    actualParticle.getPosition()[i] += actualParticle.getVelocity()[i];
                    
                    if(actualParticle.getPosition()[i]<Constants.MIN){
                        actualParticle.getPosition()[i] = Constants.MIN;
                    }else if(actualParticle.getPosition()[i]>Constants.MAX){
                        actualParticle.getPosition()[i] = Constants.MAX;
                    }
                }
                
                //System.out.println("epochs :"+actualParticle.getPosition()[0]+" "+actualParticle.getPosition()[1]+"value :"+Constants.Griewank(actualParticle.getPosition()));
                //System.out.println("globalBestSolutions :"+globalBestSolutions[0]+" "+globalBestSolutions[1]+" value:"+ Constants.Griewank(globalBestSolutions));

                if(Constants.DropWave(actualParticle.getPosition())< Constants.DropWave(actualParticle.getBestPosition())){
                    actualParticle.setBestPosition(actualParticle.getPosition());
                }

                if(Constants.DropWave(actualParticle.getBestPosition())< Constants.DropWave(globalBestSolutions)){
                    System.arraycopy(actualParticle.getBestPosition(), 0, globalBestSolutions, 0, actualParticle.getBestPosition().length);
                }
            }
            this.epochs++;
        }
    }
    private void PrintData(double[] data)
    {
        System.out.println("x:"+data[0]+"y:"+data[1]);
    }
    private void generateRandomSolution() {
        for(int i = 0; i< Constants.NUM_DIMENSIONS; ++i)
        {
            double randCoordinate = random(Constants.MIN, Constants.MAX);
            this.globalBestSolutions[i] = randCoordinate;
            
        }
        //System.out.println(" random x: " + this.globalBestSolutions[0]  +" random y: "+this.globalBestSolutions[1]);
    }
    
    private double[] initializeLocation(){
        double x = random(Constants.MIN,Constants.MAX);
        double y = random(Constants.MIN,Constants.MAX);
        double[] newLocation = new double[]{x,y};
        return newLocation;
    }
    
    private double[] initializeVelocity(){
        double vx = random(-(Constants.MAX - Constants.MIN),Constants.MAX-Constants.MIN);
        double vy = random(-(Constants.MAX - Constants.MIN),Constants.MAX-Constants.MIN);
        
        double[] newVelocity = new double[]{vx,vy};
        return newVelocity;
    }
    
    private double random(double MIN, double MAX) {
        return MIN + (MAX-MIN)*Math.random();
    }
    
    public void showSoluction(){
        System.out.println("Solution for PSO problem!");
        System.out.println("Best solution x: "+this.globalBestSolutions[0]+" - y:" +this.globalBestSolutions[1]);
        System.out.println("Value f(x,y) = " + Constants.DropWave(globalBestSolutions));
        System.out.println("Global minimum is :" + Constants.DropWave(new double[]{0,0}));
    }
    
}

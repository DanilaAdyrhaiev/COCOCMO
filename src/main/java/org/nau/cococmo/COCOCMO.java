package org.nau.cococmo;

public class COCOCMO {

    private static COCOCMO instance;

    private double[][] modelCoefficients = new double[][]
            {
                    {2.4, 1.05, 2.5, 0.38},
                    {3, 1.12, 2.5, 0.35},
                    {5.6, 1.2, 2.5, 0.32}
            };
    private double PM;
    private double TM;
    private double SS;
    private int SIZE;
    private int type;
    private COCOCMO(){

    }

    public static COCOCMO getInstance() {
        if (instance == null) {
            instance = new COCOCMO();
        }
        return instance;
    }
    public void init(int type, int size){
        this.type = type;
        this.SIZE = size;
    }

    public double[] calc(){
        calcPM();
        calcTM();
        calcSS();
        return new double[]{PM, TM, SS};
    }

    private void calcPM(){
        double[][] mc = modelCoefficients;
        PM = mc[type][0] * (Math.pow(SIZE, mc[type][1]));
    }
    private void calcTM(){
        double[][] mc = modelCoefficients;
        TM = mc[type][2]*(Math.pow(PM, mc[type][3]));
    }

    private void calcSS(){
        SS = PM/TM;
    }

}

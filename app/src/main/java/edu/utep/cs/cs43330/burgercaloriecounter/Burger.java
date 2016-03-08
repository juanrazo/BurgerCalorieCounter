package edu.utep.cs.cs43330.burgercaloriecounter;


/**
 * Created by JR on 3/7/2016.
 */
public class Burger {
    static final int BEEF = 100;
    static final int LAMB = 170;
    static final int OSTRICH = 150;
    static final int ASIAGO = 90;
    static final int CREME_FRAICHE = 120;
    static final int PROSCIUTTO = 115;

    private int mPattyCal;
    private int mCheeseCal;
    private int mProsciuttoCal;
    private int mSauceCal;

    public Burger(){
        mPattyCal = BEEF;
        mCheeseCal = ASIAGO;
        mProsciuttoCal = 0;
        mSauceCal = 0;
    }

    public int caltulateCalories(){
        return 10;
    }

    public void setmPattyCalories(int calories){
        mPattyCal = calories;
    }

    public void setmCheeseCalories(int calories){
        mCheeseCal = calories;
    }

    public void setProsciuttoCalories(int calories){
        mProsciuttoCal = calories;
    }

    public void setmSauceCalories(int calories){
        mSauceCal = calories;
    }

    public int getTotalCaolries(){
        return mPattyCal + mCheeseCal + mProsciuttoCal + mSauceCal;
    }

    public void clearProsciuttoCalories(){
        mProsciuttoCal = 0;
    }
}

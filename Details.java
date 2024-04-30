/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog;

/**
 *
 * @author User
 */
public class Details {
    private int digit;
    private int appears;
    
    public Details(int digit,int appears){
        this.appears=appears;
        this.digit=digit;
    }
    
    
    public int getDigit()
    {
        return this.digit;
    }
    
    public int getAppears()
    {
        return this.appears;
    }
    
    public void setDigit(int digit)
    {
        this.digit=digit;
    }
    
    public void setAppears(int appears)
    {
        this.appears=appears;
    }
    
    @Override
    public String toString()
    {
        return this.digit+","+this.appears;
    }
    
    
    
}

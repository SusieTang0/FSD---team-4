// Box.java
package Java_II_HOLs_01_INCLASS;

/**
 * This program calculates the area and volume of a box
 * 
 * @author Shuting Tang
 * @version 1.0
 * @since 2023-12-07
 * 
 */

public class Box extends Rectangle {
    // data members
    private double height;

    // default constructor
    public Box(){
        super();
        this.height = 0;
    } // end fault constructor
    
    // constructor with parameters
    public Box(double theLength, double theWidth,double theHeight){
        setDimension(theLength, theWidth,theHeight);
    }

    public void setDimension(double theLength, double theWidth,double theHeight){
        super.setDimension(theLength, theWidth);
        if(height >= 0){
            this.height = theHeight;
        }else{
            this.height = 0;
        }
    }

    public double getHeight(){
        return this.height;
    }

    public double getArea(){
        return 2 * (getLength() * getWidth() + getLength() * this.height + getWidth() * this.height);
    }

    public double getVolume(){
        return getArea() * this.height;
    }

    @Override
    public String toString(){
        return super.toString() + ". Height = " + this.height;
    }
}

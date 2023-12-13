// Rectangle.java
package Java_II_HOLs_01_INCLASS;

/**
 * This program calculates the area and perimeter of a rectangle
 * 
 * @author Shuting Tang
 * @version 1.0
 * @since 2023-12-07
 * 
 */

public class Rectangle{
    // data members
    private double length;
    private double width;

    // default constructor
    public Rectangle(){
        this.length = 0;
        this.width = 0;
    } // end default constructor

    // constructor with patameters
    public Rectangle(double theLength, double theWidth){
        setDimension(theLength, theWidth);
    
    } // end default constructor

    public void setDimension(double theLength, double theWidth){
        if(theLength >= 0){
            this.length = theLength;
        }else{
            this.length = 0;
        }
        if(theWidth >= 0){
            this.width = theWidth;
        }else{
            this.width = 0;
        }
    }

    public double getLength(){
        return this.length;
    }

    public double getWidth(){
        return this.width;
    }

    public double getArea(){
        return this.length * this.width;
    }

    public double getPerimeter(){
        return 2 * (this.length + this.width);
    }

    @Override
    public String toString(){
        return ("Length = " + this.length + ". Width = " + this.width);
    }


} // end class Rectangle
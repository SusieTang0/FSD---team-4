// RectangleBoxTesterOne.java

package Java_II_HOLs_01_INCLASS;

/**
 * This program test the area and volume of a rectangle and a box
 * 
 * @author Shuting Tang
 * @version 1.0
 * @since 2023-12-07
 * 
 */
public class RectangleBoxTesterOne {
    public static void main(String[] args) {
        Rectangle myRectangle = new Rectangle();
        Rectangle yourRectangle = new Rectangle(8,6);

        Box myBox = new Box();
        Box yourBox = new Box(10,7,3);
        

        System.out.println("My Rectangle: " + myRectangle);
        System.out.println();
        System.out.println("Your Rectangle: " + yourRectangle);
        System.out.println();
        System.out.println("The Area of your rectangle" + yourRectangle.getArea());
        System.out.println();

        System.out.println("My Box: " + myBox);
        System.out.println();
        System.out.println("Your Box: " +yourBox);
        System.out.println();
        System.out.println("The volume of your box: " + yourBox.getVolume());
        System.out.println();
        myRectangle.setDimension(2,1);
        System.out.println("My Rectangle: " + myRectangle);
        System.out.println();

    }
}

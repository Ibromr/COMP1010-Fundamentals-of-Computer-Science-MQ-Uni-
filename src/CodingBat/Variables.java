package CodingBat;

public class Variables {
    public static void main(String[] args) {
        System.out.println("perimeter(-10, 10) → Expected:34.14213562373095  Run:" + perimeter(-10, 10));
        System.out.println("getX(-1, 20, -5, 100, 60) → Expected:-3  Run:" + getX(-1, 20, -5, 100, 60));
    }

    /*
     * Define a function that when passed two integers representing the x and y
     * intercepts of a line, returns the perimeter of the triangle formed
     * by those two points and the origin (0, 0).
     * 
     * You can use Math.sqrt to find the square root of a number, and Math.abs to
     * find
     * the absolute value of a number.
     * 
     * The complexity of this question is in the research and analysis, not
     * the implementation.
     * 
     * 
     * perimeter(3, 4) → 12.0
     * perimeter(8, -6) → 24.0
     * perimeter(-10, 10) → 34.14213562373095
     */
    /*
     * double perimeter(int x, int y) {
     * if(x < 0 || y < 0) {
     * return perimeter(Math.abs(x), Math.abs(y));
     * }
     * return x+y+Math.sqrt(Math.pow(x,2) + Math.pow(y, 2));
     * }
     */

    // hypotenuse
    // c^2 = x^2 + y^2
    // c = Math.sqrt(Math.pow(x,2) + Math.pow(y, 2));

    // THIS IS BETTER;

    static double perimeter(int x, int y) {
        double hypotenuse = Math.sqrt(x * x + y * y);
        return hypotenuse + Math.abs(x) + Math.abs(y);
    }

    /*
     * 
     * Define a function that when passed the coordinates of two points (x1, y1)
     * and (x2, y2) through which a line passes and another value (y3),
     * returns the x-coordinate of the point on the line when y = y3.
     * 
     * You may assume the line is not vertical (because then we'll need conditions).
     * 
     * Just like the perimeter function,
     * the complexity of this question is in the research and analysis,
     * not the implementation.
     * 
     * You may assume the x-coordinate corresponding to y3 is an integer. That is,
     * the line passes through (x3, y3) where x3 and y3 are both integers.
     * 
     * 
     * getX(2, 6, 4, 12, 30) → 10
     * getX(5, 4, 20, 5, 6) → 35
     * getX(2, 6, 4, 12, -12) → -4
     */
    static int getX(int x1, int y1, int x2, int y2, int y3) {
        // Finding x-coordinate of a point on a straight line given its y-coordinate

        // General form is: y = m*x + c --> m is gradient(slope)

        double m = (y2 - y1) / (double) (x2 - x1);
        double y0 = y1 - m * x1; // when y at 0
        return (int) ((y3 - y0) / m);
    }

    // First version is not efficient
    /*
     * int getX(int x1, int y1, int x2, int y2, int y3) {
     * int xWay = Math.abs(x2 - x1);
     * int yWay = y2 - y1;
     * 
     * int distance = Math.abs(y3 - y2);
     * 
     * double diff = (double) distance / yWay;
     * 
     * return y3 > 0 ? x2 + (int)(xWay*diff) : x2-(int)(xWay*diff);
     * }
     */
}

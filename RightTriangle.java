public class RightTriangle implements Shape{

    public final Point corner;
	public final double legLength1;
    public final double legLength2;
    

    public RightTriangle(Point corner, double legLength1, double legLength2) {
		this.corner = corner;
		this.legLength1 = legLength1;
        this.legLength2 = legLength2;
    }

    public double area() {
		return (legLength2*legLength1)/2;
    }

    public double perimeter() {
		return legLength1 + legLength2 + Math.sqrt(legLength1*legLength1 + legLength2*legLength2);
    }

    public boolean isInside(Point p) {
		double xDist = p.x - corner.x;
		double yDist = p.y - corner.y;
		return 0 < xDist && xDist < legLength1 &&
			   0 < yDist && yDist < legLength2 &&
               0 < yDist && yDist < Math.sqrt(legLength1*legLength1 + legLength2*legLength2);

    }

    public boolean isOn(Point p) {
		double xDist = p.x - corner.x;
		double yDist = p.y - corner.y;
        return 0 == xDist && xDist == legLength1 &&
			   0 == yDist && yDist == legLength2 &&
               0 == yDist && yDist == Math.sqrt(legLength1*legLength1 + legLength2*legLength2);
    }

    public RightTriangle translate(double x, double y) {

        Point translatedCorner = corner.translateX(x).translateY(y);
        RightTriangle newRightTriangle = new RightTriangle(translatedCorner, legLength1, legLength2);
        return newRightTriangle;
        
	}

	public RightTriangle scale(double k) {
		return new RightTriangle(corner, legLength1 * k, legLength2 * k);
	}

    public static boolean similar(RightTriangle triangle1, RightTriangle triangle2) {

        double triangle1Ratio = triangle1.legLength1/triangle1.legLength2;
        double triangle2Ratio = triangle2.legLength1/triangle2.legLength2;
        if (triangle1Ratio == triangle2Ratio) {
            return true;
        }   else {
            return false;
        }
    }



}
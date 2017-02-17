package by.mozgo.triangle.logic;

import by.mozgo.triangle.entity.Point;
import by.mozgo.triangle.entity.Triangle;
import by.mozgo.triangle.observer.impl.TrianglePerimeter;
import by.mozgo.triangle.observer.impl.TriangleSquare;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author Andrei Mozgo
 */
public class TriangleLogic {
    private static final Logger LOGGER = LogManager.getLogger();

    public static TrianglePerimeter calculatePerimeter(Triangle triangle) {
        TrianglePerimeter trianglePerimeter = TrianglePerimeter.getInstance();
        double firstSide = calculateTriangleSide(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSide = calculateTriangleSide(triangle.getSecondPoint(), triangle.getThirdPoint());
        double thirdSide = calculateTriangleSide(triangle.getFirstPoint(), triangle.getThirdPoint());
        double perimeter = firstSide + secondSide + thirdSide;
        trianglePerimeter.getPerimeters().add(triangle.getId(), perimeter);
        LOGGER.info("Triangle perimeter = "+ perimeter);
        return trianglePerimeter;
    }

    public static TriangleSquare calculateSquare(Triangle triangle) {
        TriangleSquare triangleSquare = TriangleSquare.getInstance();
        double firstSide = calculateTriangleSide(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSide = calculateTriangleSide(triangle.getSecondPoint(), triangle.getThirdPoint());
        double thirdSide = calculateTriangleSide(triangle.getFirstPoint(), triangle.getThirdPoint());
        double halfPerimeter = 0.5 * (firstSide + secondSide + thirdSide);
        double square = Math.sqrt(halfPerimeter * (halfPerimeter - firstSide) * (halfPerimeter - secondSide) * (halfPerimeter - thirdSide));
        triangleSquare.getSquares().add(triangle.getId(), square);
        LOGGER.info("Triangle square = "+ square);
        return triangleSquare;
    }

    public static double calculateTriangleSide(Point firstPoint, Point secondPoint) {
        return Math.hypot(firstPoint.getX() - secondPoint.getX(), firstPoint.getY() - secondPoint.getY());
    }
}

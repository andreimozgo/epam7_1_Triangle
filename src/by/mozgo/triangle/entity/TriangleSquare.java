package by.mozgo.triangle.entity;

import by.mozgo.triangle.logic.TriangleLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * @author Andrei Mozgo
 */
public class TriangleSquare implements OperationObserver {
    private static TriangleSquare instance = null;
    private static final Logger logger = LogManager.getLogger();
    private ArrayList<Double> squares = new ArrayList<>();

    public static TriangleSquare getInstance() {
        if (instance == null) {
            instance = new TriangleSquare();
        }
        return instance;
    }

    public ArrayList<Double> getSquares() {
        return squares;
    }

    public void setSquares(ArrayList<Double> squares) {
        this.squares = squares;
    }

    @Override
    public void valueChanged(Triangle observed) {
        int id = observed.getId();
        logger.info("Old triangular square= " + squares.get(id));
        double newSquare = TriangleLogic.calculateSquare(observed).getSquares().get(id);
        squares.set(observed.getId(), newSquare);
        logger.info("New triangular square= " + squares.get(id));
    }
}

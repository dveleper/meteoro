package com.meli.meteoro.domain.usecase;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.meli.meteoro.domain.model.Position;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TriangulationUseCaseImpl implements TriangulationUseCase {

    @Override
    public double[] getPosition(List<Position> positions, List<Double> distances) {

        double[][] positionsArray = getPositionsArray(positions);
        double [] distancesArray = distances
                .stream()
                .mapToDouble(Double::doubleValue)
                .toArray();

        TrilaterationFunction trilaterationFunction = new TrilaterationFunction(positionsArray, distancesArray);
        NonLinearLeastSquaresSolver nSolver = new NonLinearLeastSquaresSolver(trilaterationFunction, new LevenbergMarquardtOptimizer());

        return  nSolver.solve().getPoint().toArray();
    }

    private double[][] getPositionsArray(List<Position> positions){
        double [][] positionsArray = new double[positions.size()][];
        String[] points;
        int i = 0;
        for (Position position : positions){
            points = position.toString().split(",");
            positionsArray[i] = Arrays.stream(points)
                    .map(Double::valueOf)
                    .mapToDouble(Double::doubleValue)
                    .toArray();
            i++;
        }
        return positionsArray;
    }
}

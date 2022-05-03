package com.meli.meteoro.domain.usecase;

import com.meli.meteoro.domain.model.Position;

import java.util.List;

public interface TriangulationUseCase {

    /**
     * Method for to calculate position of at object
     * @param positions must have three positions
     * @param distances must have three distances
     * @return position of object
     */
    public double[] getPosition(List<Position> positions, List<Double> distances);
}

package com.meli.meteoro.domain.usecase;

public interface TriangulationUseCase {

    /**
     * Method for to calculate position of at object
     * @param positions must have three positions
     * @param distances must have three distances
     * @return position of object
     */
    public double[] getPosition(double[][] positions, double [] distances);
}

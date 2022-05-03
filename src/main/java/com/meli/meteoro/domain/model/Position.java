package com.meli.meteoro.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Position {

    private double x;
    private  double y;

    @Override
    public String toString(){
        return x+","+y;
    }
}

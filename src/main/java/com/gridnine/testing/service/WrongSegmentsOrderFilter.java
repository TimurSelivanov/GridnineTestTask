package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.util.List;

public class WrongSegmentsOrderFilter implements Filter {

    @Override
    public List<Segment> apply(List<Flight> flightsList) {
        return null;
    }
}

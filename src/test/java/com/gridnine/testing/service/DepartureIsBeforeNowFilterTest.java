package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.util.FlightBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

class DepartureIsBeforeNowFilterTest {
    private DepartureIsBeforeNowFilter departureIsBeforeNowFilter;
    private List<Flight> testFlightList;
    @BeforeEach
    void setUp() {
        departureIsBeforeNowFilter = new DepartureIsBeforeNowFilter();
        testFlightList = FlightBuilder.createFlights();
    }

    @AfterEach
    void tearDown() {
        departureIsBeforeNowFilter = null;
        testFlightList = null;
    }

    @Test
    void getsTheListWithSizeEqualsToOne() {
        Assertions.assertEquals(1, departureIsBeforeNowFilter.apply(testFlightList).size());
    }

    @Test
    void getsFlightWhereDepartureIsBeforeNow() {
        Assertions.assertTrue(departureIsBeforeNowFilter.apply(testFlightList).get(0).getSegments()
                .get(0).getDepartureDate().isBefore(LocalDateTime.now()));
    }
}
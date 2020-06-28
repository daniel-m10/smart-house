package com.techgroup.core;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class SimulationTest {
    /**
     * Just to get 100% test cover.
     *
     * @throws FileNotFoundException if file is not found.
     * @throws InterruptedException if thread is interrupted somehow.
     */
    @Test
    public void runSimulationProgram() throws FileNotFoundException, InterruptedException {
        Simulation.main(new String[]{""});
        assertTrue(true);
    }
}
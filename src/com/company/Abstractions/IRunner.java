package com.company.Abstractions;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;

/**
 * Defines a basic runner for the program.
 */
public interface IRunner {

    /**
     * Setup handler chain.
     * @param handlers Array of handlers.
     */
    void setupHandlerChain(IHandler[] handlers);

    /**
     * Runs the program.
     * @param reader Buffer reader for reading input.
     * @throws IOException If the reader is null.
     */
    void run(BufferedReader reader) throws IOException;
}


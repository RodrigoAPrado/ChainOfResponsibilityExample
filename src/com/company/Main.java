package com.company;

import com.company.Abstractions.IHandler;
import com.company.Implementations.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        var handlers = new IHandler[4];
        handlers[0] = new AdditionHandler();
        handlers[1] = new SubtractionHandler();
        handlers[2] = new MultiplicationHandler();
        handlers[3] = new DivisionHandler();

        var runner = new DefaultRunner();
        runner.setupHandlerChain(handlers);

        var reader = new BufferedReader(new InputStreamReader(System.in));

        runner.run(reader);
    }
}

package com.company.Implementations;

import com.company.Abstractions.IHandler;
import com.company.Abstractions.IOperation;
import com.company.Abstractions.IRunner;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;

/**
 * Defines a basic runner for the program.
 */
public class DefaultRunner implements IRunner {

    private IHandler firstHandler;

    /**
     * Setup handler chain.
     * @param handlers Array of handlers.
     */
    @Override
    public void setupHandlerChain(IHandler[] handlers) {
        firstHandler = handlers[0];
        for(var handlerIndex = 1; handlerIndex < handlers.length; handlerIndex++){
            handlers[handlerIndex - 1].setNextHandlerInChain(handlers[handlerIndex]);
        }
    }

    /**
     * Runs the program.
     * @param reader Buffer reader for reading input.
     * @throws IOException If the reader is null.
     */
    @Override
    public void run(BufferedReader reader) throws IOException {
        IOperation operation = null;

        do{
            operation = getOperation(reader);

            if(operation != null){
                System.out.println("The result is : " + firstHandler.handle(operation));
            }else{
                System.out.println("Exiting...");
            }
        }while(operation != null);
    }

    private IOperation getOperation(BufferedReader reader) throws IOException {

        // Read first number.
        var firstNumber = readNumber(reader);
        if(firstNumber < 0)
            return null;

        // Read the operation.
        var operator = readOperator(reader);
        if(operator == 'q')
            return null;

        // Read second number.
        var secondNumber = readNumber(reader);
        if(secondNumber < 0)
            return null;

        return new MathOperation(firstNumber, operator, secondNumber);
    }

    private int readNumber(BufferedReader reader) throws IOException {
        System.out.println("Please enter a valid positive number or q to exit: ");
        var numberInput = reader.readLine();

        if(numberInput.charAt(0) == 'q')
            return -1;

        if(!numberInput.matches("[0-9]+"))
            return readNumber(reader);

        return Integer.parseInt(numberInput);
    }

    private char readOperator(BufferedReader reader) throws IOException {
        System.out.println("Please enter a valid operator (+, -, *, /) or q to exit: ");
        var operator = reader.readLine();

        if(operator.length() > 1)
            return readOperator(reader);

        if(operator.length() <= 0)
            return readOperator(reader);

        return operator.charAt(0);
    }
}

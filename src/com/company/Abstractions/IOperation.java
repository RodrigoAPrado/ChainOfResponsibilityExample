package com.company.Abstractions;

import com.company.Enums.OperationAction;

/**
 * Defines a math operation.
 * Operations supported: +, -, *, /
 */
public interface IOperation {

    /**
     * Gets the first number of the operation.
     */
    int getFirstNumber();

    /**
     * Gets the second number of the operation.
     */
    int getSecondNumber();

    /**
     * Gets the action of the operation.
     */
    OperationAction getOperationAction();
}

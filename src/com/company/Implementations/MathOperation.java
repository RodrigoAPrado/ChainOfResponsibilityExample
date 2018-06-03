package com.company.Implementations;

import com.company.Abstractions.IOperation;
import com.company.Enums.OperationAction;

/**
 * Defines a math operation.
 * Operations supported: +, -, *, /
 */
public class MathOperation implements IOperation {

    private int firstNumber;
    private OperationAction operation;
    private int secondNumber;

    /**
     * Initiates a new instance of MathOperation
     * @param firstNumber First number of the operation.
     * @param operation The operator.
     * @param secondNumber Second number of the operation. Cannot be zero if operator is '/'.
     */
    public MathOperation(int firstNumber, char operation, int secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;

        switch (operation){
            case '*':
                this.operation = OperationAction.Multiply;
                break;
            case '+':
                this.operation = OperationAction.Add;
                break;
            case '-':
                this.operation = OperationAction.Subtract;
                break;
            case '/':
                this.operation = OperationAction.Divide;
                break;
            default:
                this.operation = OperationAction.Unknown;
        }
    }

    @Override
    public int getFirstNumber() {
        return firstNumber;
    }

    @Override
    public int getSecondNumber() {
        return secondNumber;
    }

    @Override
    public OperationAction getOperationAction() {
        return operation;
    }
}

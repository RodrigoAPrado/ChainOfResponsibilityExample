package com.company.Implementations;

import com.company.Abstractions.IHandler;
import com.company.Abstractions.IOperation;
import com.company.Enums.OperationAction;

/**
 * Defines a handler for handling subtractions.
 */
public class SubtractionHandler extends HandlerDefaults implements IHandler {

    /**
     * Tries to perform a subtraction. Passes request forward if it can't handle or throws exception.
     * @param request Operation requested.
     * @return Operation results.
     */
    @Override
    public double handle(IOperation request) {
        try{
            if(request.getOperationAction() != OperationAction.Subtract){
                if(nextHandlerInChain == null){
                    throw new UnsupportedOperationException("The operation requested is not supported by application.");
                }
                return nextHandlerInChain.handle(request);
            }
            return request.getFirstNumber() - request.getSecondNumber();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     * Sets up the next handler in chain.
     * @param nextHandlerInChain Next handler in chain.
     */
    @Override
    public void setNextHandlerInChain(IHandler nextHandlerInChain) {
        this.nextHandlerInChain = nextHandlerInChain;
    }
}

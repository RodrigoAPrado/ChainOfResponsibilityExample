package com.company.Implementations;

import com.company.Abstractions.IHandler;
import com.company.Abstractions.IOperation;
import com.company.Enums.OperationAction;

import javax.management.InvalidAttributeValueException;

/**
 * Defines a handler for handling divisions.
 */
public class DivisionHandler extends HandlerDefaults implements IHandler {

    /**
     * Tries to perform a division. Passes request forward if it can't handle or throws exception.
     * @param request Operation requested.
     * @return Operation results.
     */
    @Override
    public double handle(IOperation request) {
        try{
            if(request.getOperationAction() != OperationAction.Divide) {
                if (nextHandlerInChain == null) {
                    throw new UnsupportedOperationException("The operation requested is not supported by application.");
                }
                return nextHandlerInChain.handle(request);
            }
            if(request.getSecondNumber() <= 0)
                throw new InvalidAttributeValueException("Cannot divide by 0.");
            return request.getFirstNumber() / request.getSecondNumber();
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

package com.company.Abstractions;

/**
 * Defines an interface for handlers.
 */
public interface IHandler {

    /**
     * Executes this handler's action.
     */
    double handle(IOperation request);

    /**
     * Sets up the next handler in chain.
     */
    void setNextHandlerInChain(IHandler nextHandlerInChain);
}

package com.smartbear.chait.handlers;

import com.smartbear.chait.command.*;

import java.util.*;

public class BritishSpokenTimeHandlerChain {

    private LinkedList<BaseTimeConvertorHandler> handlerList;

    public void addHandler(BaseTimeConvertorHandler handler) {
        if( Objects.isNull(handlerList) || handlerList.isEmpty() ) {
            handlerList = new LinkedList<>();

        }else {
            handlerList.getLast().setNextHandler(handler);
        }
        handlerList.add(handler);
    }

    public void start(BritishSpokenTimeCommand command) {
        if( handlerList.isEmpty() ){
            System.out.println("There are no handlers to handle the request");
        }

        handlerList.getFirst().handle(command);
    }

}

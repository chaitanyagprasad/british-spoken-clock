package com.smartbear.chait.handlers;

import com.smartbear.chait.command.*;
import com.smartbear.chait.constant.*;

import java.util.*;

public class MidnightHandler implements BaseTimeConvertorHandler{

    private BaseTimeConvertorHandler nextHandler;

    @Override
    public void handle(BritishSpokenTimeCommand command) {

        if(
                Objects.isNull(command.getResult()) &&
                        (  command.getHour() == 0 && command.getMinutes() == 0  )
        ){
            command.setResult(TimeWordConstants.MIDNIGHT);
        }
        nextHandler.handle(command);

    }

    @Override
    public void setNextHandler(BaseTimeConvertorHandler handler) {
        this.nextHandler = handler;
    }
}

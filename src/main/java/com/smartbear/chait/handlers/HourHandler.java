package com.smartbear.chait.handlers;

import com.smartbear.chait.command.*;
import com.smartbear.chait.constant.*;
import com.smartbear.chait.util.*;

import java.util.*;

public class HourHandler implements BaseTimeConvertorHandler {

    private BaseTimeConvertorHandler nextHandler;
    @Override
    public void handle(BritishSpokenTimeCommand command) {

        if(
                Objects.isNull(command.getResult())
        ) {
            if( TimeUtility.isNextHourProcessing(command.getMinutes()) ) {
                command.setHourInWords(TimeToWordConvertor.convert(command.getHour()+1));
            } else if (command.getHour() == 0) {
                command.setHourInWords(TimeWordConstants.MIDNIGHT);
            }else {
                command.setHourInWords(TimeToWordConvertor.convert(command.getHour()));
            }
        }
        nextHandler.handle(command);

    }

    @Override
    public void setNextHandler(BaseTimeConvertorHandler handler) {
        this.nextHandler = handler;
    }


}

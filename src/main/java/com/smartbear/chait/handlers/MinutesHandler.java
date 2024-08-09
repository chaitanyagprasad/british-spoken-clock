package com.smartbear.chait.handlers;

import com.smartbear.chait.command.*;
import com.smartbear.chait.util.*;

import java.sql.*;
import java.util.*;

public class MinutesHandler implements BaseTimeConvertorHandler{

    private BaseTimeConvertorHandler nextHandler;

    @Override
    public void handle(BritishSpokenTimeCommand command) {
        if(
                Objects.isNull(command.getResult())
        ) {

            command.setMinutesInWords(
                    TimeToWordConvertor.convertMinutes(
                            TimeUtility.isNextHourProcessing(command.getMinutes()) ?
                                    60 - command.getMinutes() : command.getMinutes()
                    )
            );
        }
        nextHandler.handle(command);
    }

    @Override
    public void setNextHandler(BaseTimeConvertorHandler handler) {
        this.nextHandler = handler;
    }
}

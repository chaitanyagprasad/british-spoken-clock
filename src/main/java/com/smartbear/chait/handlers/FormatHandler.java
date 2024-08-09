package com.smartbear.chait.handlers;

import com.smartbear.chait.command.*;
import com.smartbear.chait.formatter.*;

import java.util.*;

public class FormatHandler implements BaseTimeConvertorHandler{

    private BaseTimeConvertorHandler nextHandler;
    @Override
    public void handle(BritishSpokenTimeCommand command) {
        if(
                Objects.isNull(command.getResult()) &&
                        Objects.nonNull(command.getHourInWords()) &&
                        Objects.nonNull(command.getMinutes())
        ) {
            command.setResult(
                    TimeFormatter.format(
                            command.getHourInWords(),
                            command.getMinutesInWords(),
                            command.getMinutes()
                    )
            );

        }

    }

    @Override
    public void setNextHandler(BaseTimeConvertorHandler handler) {

    }
}

package com.smartbear.chait.handlers;

import com.smartbear.chait.command.*;

public interface BaseTimeConvertorHandler {

    default void handle(BritishSpokenTimeCommand command){
    }

    void setNextHandler(BaseTimeConvertorHandler handler);

}

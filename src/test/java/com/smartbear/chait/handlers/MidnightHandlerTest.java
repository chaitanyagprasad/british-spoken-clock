package com.smartbear.chait.handlers;

import com.smartbear.chait.command.*;
import com.smartbear.chait.constant.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MidnightHandlerTest {

    private MidnightHandler midnightHandler;
    private BritishSpokenTimeCommand mockCommand;
    private BaseTimeConvertorHandler nextHandler;

    @BeforeEach
    void setUp() {
        midnightHandler = new MidnightHandler();
        mockCommand = mock(BritishSpokenTimeCommand.class);
        nextHandler = mock(BaseTimeConvertorHandler.class);
        midnightHandler.setNextHandler(nextHandler);
    }

    @Test
    void testHandle_ShouldSetResultToMidnight_WhenHourAndMinutesAreZero() {
        // Arrange
        when(mockCommand.getResult()).thenReturn(null);
        when(mockCommand.getHour()).thenReturn(0);
        when(mockCommand.getMinutes()).thenReturn(0);

        // Act
        midnightHandler.handle(mockCommand);

        // Assert
        verify(mockCommand).setResult(TimeWordConstants.MIDNIGHT);
        verify(nextHandler).handle(mockCommand);
    }

    @Test
    void testHandle_ShouldNotSetResult_WhenResultIsNotNull() {
        // Arrange
        when(mockCommand.getResult()).thenReturn("Already Set");

        // Act
        midnightHandler.handle(mockCommand);

        // Assert
        verify(mockCommand, never()).setResult(anyString());
        verify(nextHandler).handle(mockCommand);
    }

    @Test
    void testHandle_ShouldNotSetResult_WhenHourIsNotZero() {
        // Arrange
        when(mockCommand.getResult()).thenReturn(null);
        when(mockCommand.getHour()).thenReturn(1);
        when(mockCommand.getMinutes()).thenReturn(0);

        // Act
        midnightHandler.handle(mockCommand);

        // Assert
        verify(mockCommand, never()).setResult(anyString());
        verify(nextHandler).handle(mockCommand);
    }

    @Test
    void testHandle_ShouldNotSetResult_WhenMinutesAreNotZero() {
        // Arrange
        when(mockCommand.getResult()).thenReturn(null);
        when(mockCommand.getHour()).thenReturn(0);
        when(mockCommand.getMinutes()).thenReturn(15);

        // Act
        midnightHandler.handle(mockCommand);

        // Assert
        verify(mockCommand, never()).setResult(anyString());
        verify(nextHandler).handle(mockCommand);
    }


}
package com.smartbear.chait.handlers;

import com.smartbear.chait.command.*;
import com.smartbear.chait.constant.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class NoonHandlerTest {

    private NoonHandler noonHandler;
    private BritishSpokenTimeCommand mockCommand;
    private BaseTimeConvertorHandler nextHandler;

    @BeforeEach
    void setUp() {
        noonHandler = new NoonHandler();
        mockCommand = mock(BritishSpokenTimeCommand.class);
        nextHandler = mock(BaseTimeConvertorHandler.class);
        noonHandler.setNextHandler(nextHandler);
    }

    @Test
    void testHandle_ShouldSetResultToNoon_WhenHourIsTwelveAndMinutesAreZero() {
        // Arrange
        when(mockCommand.getResult()).thenReturn(null);
        when(mockCommand.getHour()).thenReturn(12);
        when(mockCommand.getMinutes()).thenReturn(0);

        // Act
        noonHandler.handle(mockCommand);

        // Assert
        verify(mockCommand).setResult(TimeWordConstants.NOON);
        verify(nextHandler).handle(mockCommand);
    }

    @Test
    void testHandle_ShouldNotSetResult_WhenResultIsNotNull() {
        // Arrange
        when(mockCommand.getResult()).thenReturn("Already Set");

        // Act
        noonHandler.handle(mockCommand);

        // Assert
        verify(mockCommand, never()).setResult(anyString());
        verify(nextHandler).handle(mockCommand);
    }

    @Test
    void testHandle_ShouldNotSetResult_WhenHourIsNotTwelve() {
        // Arrange
        when(mockCommand.getResult()).thenReturn(null);
        when(mockCommand.getHour()).thenReturn(11);
        when(mockCommand.getMinutes()).thenReturn(0);

        // Act
        noonHandler.handle(mockCommand);

        // Assert
        verify(mockCommand, never()).setResult(anyString());
        verify(nextHandler).handle(mockCommand);
    }

    @Test
    void testHandle_ShouldNotSetResult_WhenMinutesAreNotZero() {
        // Arrange
        when(mockCommand.getResult()).thenReturn(null);
        when(mockCommand.getHour()).thenReturn(12);
        when(mockCommand.getMinutes()).thenReturn(15);

        // Act
        noonHandler.handle(mockCommand);

        // Assert
        verify(mockCommand, never()).setResult(anyString());
        verify(nextHandler).handle(mockCommand);
    }

}

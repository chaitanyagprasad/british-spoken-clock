package com.smartbear.chait.handlers;

import com.smartbear.chait.command.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MinutesHandlerTest {

    private MinutesHandler minutesHandler;
    private BritishSpokenTimeCommand mockCommand;
    private BaseTimeConvertorHandler nextHandler;

    @BeforeEach
    void setUp() {
        minutesHandler = new MinutesHandler();
        mockCommand = mock(BritishSpokenTimeCommand.class);
        nextHandler = mock(BaseTimeConvertorHandler.class);
        minutesHandler.setNextHandler(nextHandler);
    }

    @Test
    void testHandle_ShouldSetMinutesInWords_WhenNextHourProcessing() {
        // Arrange
        when(mockCommand.getResult()).thenReturn(null);
        when(mockCommand.getMinutes()).thenReturn(45);


        // Act
        minutesHandler.handle(mockCommand);

        // Assert
        verify(mockCommand).setMinutesInWords("quarter");
        verify(nextHandler).handle(mockCommand);
    }

    @Test
    void testHandle_ShouldSetMinutesInWords_WhenNotNextHourProcessing() {
        // Arrange
        when(mockCommand.getResult()).thenReturn(null);
        when(mockCommand.getMinutes()).thenReturn(15);


        // Act
        minutesHandler.handle(mockCommand);

        // Assert
        verify(mockCommand).setMinutesInWords("quarter");
        verify(nextHandler).handle(mockCommand);
    }

    @Test
    void testHandle_ShouldNotSetMinutesInWords_WhenResultIsNotNull() {
        // Arrange
        when(mockCommand.getResult()).thenReturn("Already Set");

        // Act
        minutesHandler.handle(mockCommand);

        // Assert
        verify(mockCommand, never()).setMinutesInWords(anyString());
        verify(nextHandler).handle(mockCommand);
    }

}
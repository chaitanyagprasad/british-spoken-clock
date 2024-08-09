package com.smartbear.chait.handlers;

import com.smartbear.chait.command.*;
import com.smartbear.chait.constant.*;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;

class HourHandlerTest {

    private HourHandler hourHandler;
    private BritishSpokenTimeCommand mockCommand;
    private BaseTimeConvertorHandler nextHandler;

    @BeforeEach
    void setUp() {
        hourHandler = new HourHandler();
        mockCommand = mock(BritishSpokenTimeCommand.class);
        nextHandler = mock(BaseTimeConvertorHandler.class);
        hourHandler.setNextHandler(nextHandler);
    }

    @Test
    void testHandle_ShouldSetHourInWordsToNextHour_WhenNextHourProcessing() {
        // Arrange
        when(mockCommand.getResult()).thenReturn(null);
        when(mockCommand.getMinutes()).thenReturn(45);
        when(mockCommand.getHour()).thenReturn(5);


        // Act
        hourHandler.handle(mockCommand);

        // Assert
        verify(mockCommand).setHourInWords("six");
        verify(nextHandler).handle(mockCommand);
    }

    @Test
    void testHandle_ShouldSetHourInWordsToMidnight_WhenHourIsZero() {
        // Arrange
        when(mockCommand.getResult()).thenReturn(null);
        when(mockCommand.getMinutes()).thenReturn(0);
        when(mockCommand.getHour()).thenReturn(0);

        // Act
        hourHandler.handle(mockCommand);

        // Assert
        verify(mockCommand).setHourInWords(TimeWordConstants.MIDNIGHT);
        verify(nextHandler).handle(mockCommand);
    }

    @Test
    void testHandle_ShouldSetHourInWordsToCurrentHour_WhenNotNextHourProcessing() {
        // Arrange
        when(mockCommand.getResult()).thenReturn(null);
        when(mockCommand.getMinutes()).thenReturn(15);
        when(mockCommand.getHour()).thenReturn(5);

        // Act
        hourHandler.handle(mockCommand);

        // Assert
        verify(mockCommand).setHourInWords("five");
        verify(nextHandler).handle(mockCommand);
    }

    @Test
    void testHandle_ShouldNotSetHourInWords_WhenResultIsNotNull() {
        // Arrange
        when(mockCommand.getResult()).thenReturn("Already Set");

        // Act
        hourHandler.handle(mockCommand);

        // Assert
        verify(mockCommand, never()).setHourInWords(anyString());
        verify(nextHandler).handle(mockCommand);
    }

}
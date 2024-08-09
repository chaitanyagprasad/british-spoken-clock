package com.smartbear.chait.handlers;


import com.smartbear.chait.command.*;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;

class FormatHandlerTest {

    private FormatHandler formatHandler;
    private BritishSpokenTimeCommand mockCommand;

    @BeforeEach
    void setUp() {
        formatHandler = new FormatHandler();
        mockCommand = mock(BritishSpokenTimeCommand.class);
    }

    @Test
    void testHandle_ShouldSetResult_WhenConditionsMet() {
        // Arrange
        when(mockCommand.getResult()).thenReturn(null);
        when(mockCommand.getHourInWords()).thenReturn("three");
        when(mockCommand.getMinutes()).thenReturn(15);
        when(mockCommand.getMinutesInWords()).thenReturn("quarter");

        // Act
        formatHandler.handle(mockCommand);

        // Assert
        verify(mockCommand).setResult("quarter past three");
    }

    @Test
    void testHandle_ShouldNotSetResult_WhenResultIsNotNull() {
        // Arrange
        when(mockCommand.getResult()).thenReturn("Already Set");

        // Act
        formatHandler.handle(mockCommand);

        // Assert
        verify(mockCommand, never()).setResult(anyString());
    }

    @Test
    void testHandle_ShouldNotSetResult_WhenHourInWordsIsNull() {
        // Arrange
        when(mockCommand.getResult()).thenReturn(null);
        when(mockCommand.getHourInWords()).thenReturn(null);

        // Act
        formatHandler.handle(mockCommand);

        // Assert
        verify(mockCommand, never()).setResult(anyString());
    }

    @Test
    void testHandle_ShouldNotSetResult_WhenMinutesIsNull() {
        // Arrange
        when(mockCommand.getResult()).thenReturn(null);
        when(mockCommand.getHourInWords()).thenReturn("three");
        when(mockCommand.getMinutes()).thenReturn(null);

        // Act
        formatHandler.handle(mockCommand);

        // Assert
        verify(mockCommand, never()).setResult(anyString());
    }


}
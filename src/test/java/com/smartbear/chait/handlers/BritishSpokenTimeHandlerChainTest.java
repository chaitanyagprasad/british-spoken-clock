package com.smartbear.chait.handlers;

import com.smartbear.chait.command.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BritishSpokenTimeHandlerChainTest {
    private BritishSpokenTimeHandlerChain handlerChain;
    private BaseTimeConvertorHandler mockHandler1;
    private BaseTimeConvertorHandler mockHandler2;
    private BritishSpokenTimeCommand mockCommand;

    @BeforeEach
    void setUp() {
        handlerChain = new BritishSpokenTimeHandlerChain();
        mockHandler1 = mock(BaseTimeConvertorHandler.class);
        mockHandler2 = mock(BaseTimeConvertorHandler.class);
        mockCommand = mock(BritishSpokenTimeCommand.class);
    }

    @Test
    void testAddHandler_FirstHandler() {
        handlerChain.addHandler(mockHandler1);

        // Verify that the handler was added
        LinkedList<BaseTimeConvertorHandler> handlerList = (LinkedList<BaseTimeConvertorHandler>)
                getField(handlerChain, "handlerList");
        assertThat(handlerList).hasSize(1);
        assertThat(mockHandler1).isEqualTo(handlerList.getFirst());
    }

    @Test
    void testAddHandler_MultipleHandlers() {
        handlerChain.addHandler(mockHandler1);
        handlerChain.addHandler(mockHandler2);

        // Verify that the handlers were added in the correct order and chained
        LinkedList<BaseTimeConvertorHandler> handlerList = (LinkedList<BaseTimeConvertorHandler>)
                getField(handlerChain, "handlerList");
        assertThat(handlerList).hasSize(2);
        assertThat(mockHandler1).isEqualTo(handlerList.getFirst());
        assertThat(mockHandler2).isEqualTo(handlerList.getLast());
        verify(mockHandler1).setNextHandler(mockHandler2);
    }

    @Test
    void testStart_WithHandlers() {
        handlerChain.addHandler(mockHandler1);
        handlerChain.start(mockCommand);

        // Verify that the first handler's handle method was called
        verify(mockHandler1).handle(mockCommand);
    }

    // Utility method to access private fields for testing
    private Object getField(Object object, String fieldName) {
        try {
            var field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
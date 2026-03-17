package org.yolkin.eventsCollectorService;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class ContextTest {

    @Test
    public void test1() {
        assertTrue(true);
    }
}
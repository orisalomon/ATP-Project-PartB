package algorithms.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {

    @Test
    void getName() {
        BestFirstSearch best = new BestFirstSearch();
        assertEquals("BEST-FS",best.getName());
    }

    @Test
    void testNull() {
        BestFirstSearch best = new BestFirstSearch();
        //assertFalse(best.solve());
    }
}
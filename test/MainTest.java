package test;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest {
    
    // simple test to see if the array of keyword is well sorted
    @Test
    public void testKeywordSorting() {
        String[] unsortedKeywords = new String[]{"Pandora", "Pinterest", "Paypal", "Pg&e", "Project free tv", "Priceline", "Press democrat", "Progressive", "Project runway", "Proactive", "Programming", "Progeria", "Progesterone", "Progenex", "Procurable", "Processor", "Proud", "Print", "Prank", "Bowl", "Owl", "River", "Phone", "Kayak", "Stamps", "Reprobe"};
        String[] expectedSortedKeywords = new String[]{"Bowl", "Kayak", "Owl", "Pandora", "Paypal", "Pg&e", "Phone", "Pinterest", "Prank", "Press democrat", "Priceline", "Print", "Proactive", "Processor", "Procurable", "Progenex", "Progeria", "Progesterone", "Programming", "Progressive", "Project free tv", "Project runway", "Proud", "Reprobe", "River", "Stamps"};


        Arrays.sort(unsortedKeywords);

        assertArrayEquals(expectedSortedKeywords, unsortedKeywords);
    }
}

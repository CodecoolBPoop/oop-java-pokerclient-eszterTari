import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    public void constructor_ThrowsException_IfColorIsIllegal() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Card("E4"));
        assertEquals("card color isn't valid: E", thrown.getMessage());
    }

    @Test
    public void constructor_ThrowsException_IfValueIsIllegal() {
        assertThrows(IllegalArgumentException.class, () -> new Card("H0"));
    }

    @Test
    public void constructor_ThrowsException_IfValueIsLetter() {
        assertThrows(IllegalArgumentException.class, () -> new Card("HH"));
    }

    @Test
    public void getValue() throws Exception {
        PokerClient pokerClient = new PokerClient("h3", "s2", "dj", "c4", "ck");
        List<Integer> expectedValues = new ArrayList<>(Arrays.asList(3, 2, 11, 4, 13));
        int card1Value = pokerClient.card1.getValue();
        int card2Value = pokerClient.card2.getValue();
        int card3Value = pokerClient.card3.getValue();
        int card4Value = pokerClient.card4.getValue();
        int card5Value = pokerClient.card5.getValue();
        List<Integer> cardValues = new ArrayList<>(Arrays.asList(card1Value, card2Value, card3Value, card4Value, card5Value));
        assertEquals(expectedValues, cardValues);
    }
}
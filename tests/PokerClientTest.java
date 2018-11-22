import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerClientTest {

    private PokerClient pokerClient = new PokerClient("h3", "s2", "dj", "c4", "ck");

    @Test
    public void highestCardIsMine_False_IfOpponentHasAHigherCard() throws Exception {
        boolean isHighestCardMine = pokerClient.highestCardIsMine("h4", "s5", "cj", "c5", "ca");
        assertFalse(isHighestCardMine);
    }

    @Test
    public void highestCardIsMine_True_IfOpponentHasOnlyLowerCards() throws Exception {
        boolean isHighestCardMine = pokerClient.highestCardIsMine("h4", "s5", "cj", "c5", "cq");
        assertTrue(isHighestCardMine);
    }

    @Test
    public void highestCardIsMine_False_IfHighestValueIsTheSame() throws Exception {
        boolean isHighestCardMine = pokerClient.highestCardIsMine("h4", "s5", "cj", "c5", "hk");
        assertFalse(isHighestCardMine);
    }
}
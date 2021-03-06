import java.util.HashMap;

public class Card {

    String cardCode;
    static HashMap<String, Integer> alphabeticCardValue = new HashMap<>();
    static {
        alphabeticCardValue.put("J", 11);
        alphabeticCardValue.put("Q", 12);
        alphabeticCardValue.put("K", 13);
        alphabeticCardValue.put("A", 14);
    }

    public Card(String cardCode) throws IllegalArgumentException {
        this.cardCode = cardCode;

        String cardColor = this.cardCode.substring(0, 1).toUpperCase();

        if (!cardColor.matches("S|C|D|H"))
        {
            throw new IllegalArgumentException("card color isn't valid: " + cardColor);
        }

        String cardValue = cardCode.substring(1).toUpperCase();
        Integer intCardValue = Integer.parseInt(cardValue);

        if (alphabeticCardValue.get(cardCode.substring(1).toUpperCase()) == null) {
            // raises exception if cardValue is a letter, but not J/Q/K/A
            if (intCardValue > 10 || intCardValue < 2) {
                throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
            }
        }
    }

    public int getValue() {
        String cardValue = cardCode.substring(1).toUpperCase();
        Integer intCardValue;

        if (alphabeticCardValue.get(cardCode.substring(1).toUpperCase()) == null) {
            intCardValue = Integer.parseInt(cardValue);
        } else {
            intCardValue = alphabeticCardValue.get(cardCode.substring(1).toUpperCase());
        }

        return intCardValue;
    }
}

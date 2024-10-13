public class PaymentProcessor {

    public boolean processPayment(String cardNumber, String cvv, String expirationDate, float price) {
        if (isCardNumberValid(cardNumber) && isCVVValid(cvv) && isExpirationDateValid(expirationDate) && price > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isCardNumberValid(String cardNumber) {
        if (cardNumber == null || cardNumber.length() != 16) {
            return false;
        }

        for (char c : cardNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCVVValid(String cvv) {
        if (cvv == null || cvv.length() != 3) {
            return false;
        }

        for (char c : cvv.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean isExpirationDateValid(String expirationDate) {
        if (expirationDate == null || expirationDate.length() != 5 || expirationDate.charAt(2) != '/') {
            return false;
        }

        int expMonth;
        int expYear;
        try {
            expMonth = Integer.parseInt(expirationDate.substring(0, 2));
            expYear = Integer.parseInt("20" + expirationDate.substring(3, 5));
        } catch (NumberFormatException e) {
            return false;
        }

        if (expMonth < 1 || expMonth > 12) {
            return false;
        }

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        int currentMonth = calendar.get(java.util.Calendar.MONTH) + 1;
        int currentYear = calendar.get(java.util.Calendar.YEAR);

        return (expYear > currentYear) || (expYear == currentYear && expMonth >= currentMonth);
    }
}

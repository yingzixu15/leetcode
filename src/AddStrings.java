public class AddStrings {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (p1 >= 0 && p2 >= 0) {
            int d1 = Integer.parseInt("" + num1.charAt(p1));
            int d2 = Integer.parseInt("" + num2.charAt(p2));
            int dResult = d1 + d2 + carry;
            if (dResult >= 10) {
                carry = 1;
                dResult -= 10;
            } else carry = 0;
            result.append(dResult);
            p1--;
            p2--;
        }
        if (p1 >= 0) {
            while (p1 >= 0) {
                int d1 = Integer.parseInt("" + num1.charAt(p1));
                int dResult = d1 + carry;
                if (dResult >= 10) {
                    carry = 1;
                    dResult -= 10;
                } else carry = 0;
                result.append(dResult);
                p1--;
            }
        } else if (p2 >= 0) {
            while (p2 >= 0) {
                int d2 = Integer.parseInt("" + num2.charAt(p2));
                int dResult = d2 + carry;
                if (dResult >= 10) {
                    carry = 1;
                    dResult -= 10;
                } else carry = 0;
                result.append(dResult);
                p2--;
            }
        }
        if (carry == 1)
            result.append(carry);
        return result.reverse().toString();
    }
}

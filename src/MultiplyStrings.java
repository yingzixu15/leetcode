import java.util.LinkedList;
import java.util.List;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        if (num1.length() <= num2.length())
            return multiplyHelper(num2, num1);
        else return multiplyHelper(num1, num2);
    }

    // assumption: num1 is longer than or equal length to num2
    private String multiplyHelper(String num1, String num2) {
        List<String> tempResults = new LinkedList<>();
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder stringBuilder = new StringBuilder();
            int d2 = Integer.parseInt(String.valueOf(num2.charAt(i)));
            int carry = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int d1 = Integer.parseInt(String.valueOf(num1.charAt(j)));
                int result = d1 * d2 + carry;
                stringBuilder.append(result % 10);
                carry = result / 10;
            }
            if (carry != 0)
                stringBuilder.append(carry);
            tempResults.add(stringBuilder.reverse().toString());
        }
        String result = tempResults.remove(0);
        int numZeros = 1;
        while (!tempResults.isEmpty()) {
            result = multiplyHelperAddition(result, tempResults.remove(0), numZeros);
            numZeros++;
        }
        return result;
    }

    // calculates num1 + 10^(numZeros) * num2
    private String multiplyHelperAddition(String num1, String num2, int numZeros) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numZeros; i++)
            stringBuilder.append(num1.charAt(num1.length() - 1 - i));
        int pointer = 0;
        int t1 = num1.length() - 1 - numZeros;
        int t2 = num2.length() - 1;
        int carry = 0;
        while (pointer <= t1 && pointer <= t2) {
            int d = Integer.parseInt(String.valueOf(num1.charAt(t1 - pointer)))
                    + Integer.parseInt(String.valueOf(num2.charAt(t2 - pointer))) + carry;
            if (d >= 10) {
                carry = 1;
                d -= 10;
            } else carry = 0;
            stringBuilder.append(d);
            pointer++;
        }
        if (pointer <= t1) {
            carry = addUpLeftover(num1, stringBuilder, pointer, t1, carry);
        } else if (pointer <= t2) {
            carry = addUpLeftover(num2, stringBuilder, pointer, t2, carry);
        }
        if (carry != 0)
            stringBuilder.append(carry);
        return stringBuilder.reverse().toString();
    }

    private int addUpLeftover(String num, StringBuilder stringBuilder, int pointer, int t, int carry) {
        while (pointer <= t) {
            int d = Integer.parseInt(String.valueOf(num.charAt(t - pointer))) + carry;
            if (d >= 10) {
                carry = 1;
                d -= 10;
            } else carry = 0;
            stringBuilder.append(d);
            pointer++;
        }
        return carry;
    }
}

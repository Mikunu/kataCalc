import java.util.HashMap;


class Converter {
    HashMap<Character, Integer> romanKeyMap = new HashMap<>();

    Converter()
    {
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);
        romanKeyMap.put('D', 500);
        romanKeyMap.put('M', 1000);
    }

    boolean isRoman(String value)
    {
        return romanKeyMap.containsKey(value.charAt(0));
    }

    int romanToInt(String s)
    {
        int result = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (i < s.length() - 1 && romanKeyMap.get(s.charAt(i)) < romanKeyMap.get(s.charAt(i + 1)))
            {
                result -= romanKeyMap.get(s.charAt(i));
            } else
            {
                result += romanKeyMap.get(s.charAt(i));
            }
        }

        return result;
    }

    String intToRoman(int value)
    {
        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanValues = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arabicValues.length && value > 0; i++) {
            while (value >= arabicValues[i]){
                result.append(romanValues[i]);
                value -= arabicValues[i];
            }
        }

        return result.toString();
    }
}

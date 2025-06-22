package CodingBat;

public class LearningStrings {
    public static void main(String[] args) {

        // System.out.println(isNiceOrder(new ArrayList<>(Arrays.asList(10, 20,
        // 20,40))));

        System.out.println(removeAt("super", 2));

    }

    /*
     * Define a function that when passed a String and two characters, 
     * returns the String with every occurrence of the first character 
     * replaced by the second character. You should not use the built-in methods 
     * replace() or replaceAll().


    replace("hallelujah", "h", "p") → "pallelujap"
    replace("hallelujah", "l", "p") → "happepujah"
    replace("ssussussu", "s", "!") → "!!u!!u!!u"
     */

    static String replace(String s, char from, char to) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == from) {
                sb.setCharAt(i, to);
            }
        }
        return sb.toString();
    }

    /*
    Define a function that when passed a String and an integer (say idx), 
    returns a String with the character at idx (if any) removed from the original String.

    removeAt("super", 2) → "suer"
    removeAt("nicely done", 6) → "nicelydone"
    removeAt("really?", -1) → "really?"
    */
    static String removeAt(String s, int idx) {
        if (idx < 0 || idx > s.length() || s.length() == 0) {
            return s;
        }
        // StringBuilder sb = new StringBuilder(s);
        // sb.deleteCharAt(idx);
        // s = sb.toString();
        if (idx == 0) {
            s = s.substring(1);
        } else if (idx == s.length()) {
            s = s.substring(0, s.length());
        } else {
            s = s.substring(0, idx) + s.substring(idx + 1);
        }
        return s;
    }
}

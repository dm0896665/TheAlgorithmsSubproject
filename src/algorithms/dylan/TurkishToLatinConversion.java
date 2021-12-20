package algorithms.dylan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Converts turkish character to latin character
 *
 * @author Özgün Gökşenli
 */
public class TurkishToLatinConversion {

    /**
     * Main method
     *
     * @param args Command line arguments
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the string: ");
        String b = sc.next();
        StringBuilder str = new StringBuilder();
        char ch[] = b.toCharArray();
        for(int i = 0; i < ch.length; i++) {
           String hexString = Integer.toHexString(ch[i]);
           str.append("0x" + hexString.toUpperCase() + ",");
        }
        System.out.println("Converted: " + convertTurkishToLatin(str.toString()));
        sc.close();
    }

    /**
     * This method converts a turkish character to latin character.
     *
     * @param param String paramter
     * @return String
     */
    public static String convertTurkishToLatin(String param) {
        String[] turkishChars
                = new String[]{"0x131", "0x130", "0xFC", "0xDC", "0xF6", "0xD6", "0x15F", "0x15E", "0xE7", "0xC7", "0x11F", "0x11E"};
        char[] latinChars = new char[]{'i', 'I', 'u', 'U', 'o', 'O', 's', 'S', 'c', 'C', 'g', 'G'};
        StringBuilder latin = new StringBuilder();
        String[] paramArr = param.split(",");
        for (int i = 0; i < paramArr.length; i++) {
        	if(Arrays.asList(turkishChars).indexOf(paramArr[i]) > 0) {
        		latin.append(latinChars[Arrays.asList(turkishChars).indexOf(paramArr[i])]);
        	} else {
        		latin.append(paramArr[i]);
        	}
        }
        return latin.toString();
    }
}

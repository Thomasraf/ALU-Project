
import java.util.Scanner;

public class Input {

    private String input;
    private String input1;
    private String input2;
    private String exponent;
    private boolean check = false;
    private int radixCheck = 0;
    private int actualValue = 0;
    private String signBit = "0";
    private String combiField;
    private String exponent6;
    private String mantissa;
    Scanner sc = new Scanner(System.in);

    public void Conversion() {

        while(check != true) {
            System.out.println("PLEASE INPUT A DECIMAL NUMBER. LIM: 16 digits");
            input = sc.nextLine();
         
            if(input.matches("[0-9]+[a-zA-Z]+") || input.matches("[a-zA-Z]+")) {
            	System.out.println("PLEASE INPUT A VALID DIGIT.");
            	break;
            }
            
            if(input != "") {
            if(input.contains("-")) { //This is for the sign bit, delete the character and change the value of the sign bit from 0 (what it is originally) to 1 
                signBit = "1";
                StringBuilder sb = new StringBuilder(input);
                sb.deleteCharAt(0);

                input = sb.toString();
            }

            if(input.contains(".")) { //This is for the radix point in the middle of the digit sequence.

            String[] inputArray = input.split("\\.");
            input1 = inputArray[0];
            input2 = inputArray[1];

                if(input1.length() > input2.length()) {
                    radixCheck = input2.length() * -1;
                }

                else if(input1.length() < input2.length() || input1.length() == input2.length()) {
                    radixCheck = input1.length();
                }

                input = input1 + input2;

            }

            if (input.length() <= 16) { //Actual implementation of the code
                System.out.println("PLEASE INPUT THE EXPONENT OF THE NUMBER");
                exponent = sc.nextLine();

                
                if (input.length() < 16) //To make sure that is it the correct amount of digits inputted 
                    for (int i = input.length(); i < 16; i++)
                        input = '0' + input;
                
              
                    String decString = DectoBinary(input.charAt(0));
                    actualValue = radixCheck + Integer.parseInt(exponent);
                    int ruleChecking = actualValue + 398;
                    exponent = ePrimeBinary(actualValue);
                    
                    if(input.equals("") && ruleChecking < 0) {
                    	System.out.println("N/A");
                    	
                    }
                    
                    
                    else if(ruleChecking <= 767 && ruleChecking >= 0 && !input.equals("0000000000000000")) { //Checking for which rule should be followed
                    
	                    if(Integer.parseInt(String.valueOf(input.charAt(0))) < 8){
	                       decString = decString.substring(1, 4);
	                       String x = exponent.substring(0, 2);		
	
	                       combiField = x + decString;
	                       exponent6 = exponent.substring(2, 10);
	
	                       mantissa = input.substring(1, 16);
	
	                        String setOne = binaryExpansion(mantissa.substring(0,3));
	                        String setTwo = binaryExpansion(mantissa.substring(3,6));
	                        String setThree = binaryExpansion(mantissa.substring(6,9));
	                        String setFour = binaryExpansion(mantissa.substring(9,12));
	                        String setFive = binaryExpansion(mantissa.substring(12,15));
	
	                        String firstBCD = packedBCD(setOne);
	                        String secondBCD = packedBCD(setTwo);
	                        String thirdBCD = packedBCD(setThree);
	                        String fourthBCD = packedBCD(setFour);
	                        String fifthBCD = packedBCD(setFive);
	
	                        String fullBCD = firstBCD + secondBCD + thirdBCD + fourthBCD + fifthBCD;
	                       
	                        
	                       System.out.println("Your corrected input: " + input);
	
	                       System.out.println("Your floating point: " + signBit + " | " + combiField + " | " + exponent6 + " | " + fullBCD);
	
	                       String output = signBit + combiField + exponent6 + fullBCD;
	
	                       String hex0 = BinarytoHex(output.substring(0,4));
	                       String hex1 = BinarytoHex(output.substring(4,8));
	                       String hex2 = BinarytoHex(output.substring(8,12));
	                       String hex3 = BinarytoHex(output.substring(12,16));
	                       String hex4 = BinarytoHex(output.substring(16,20));
	                       String hex5 = BinarytoHex(output.substring(20,24));
	                       String hex6 = BinarytoHex(output.substring(24,28));
	                       String hex7 = BinarytoHex(output.substring(28,32));
	                       String hex8 = BinarytoHex(output.substring(32,36));
	                       String hex9 = BinarytoHex(output.substring(36,40));
	                       String hexA = BinarytoHex(output.substring(40,44));
	                       String hexB = BinarytoHex(output.substring(44,48));
	                       String hexC = BinarytoHex(output.substring(48,52));
	                       String hexD = BinarytoHex(output.substring(52,56));
	                       String hexE = BinarytoHex(output.substring(56,60));
	                       String hexF = BinarytoHex(output.substring(60,64));
	
	                      System.out.println("Converted to Hex: " + hex0+hex1+hex2+hex3+hex4+hex5+hex6+hex7+hex8+hex9+hexA+hexB+hexC+hexD+hexE+hexF);
	                      check = endingCase(check);
	                    }
	                    else if(Integer.parseInt(String.valueOf(input.charAt(0))) >= 8) {
	                        decString = decString.substring(3, 4);
	                        String x = exponent.substring(0, 2);
	
	                        combiField = "11" + x + decString;
	
	
	                        exponent6 = exponent.substring(2, 10);
	
	                        mantissa = input.substring(1, 16);
	
	                        String setOne = binaryExpansion(mantissa.substring(0,3));
	                        String setTwo = binaryExpansion(mantissa.substring(3,6));
	                        String setThree = binaryExpansion(mantissa.substring(6,9));
	                        String setFour = binaryExpansion(mantissa.substring(9,12));
	                        String setFive = binaryExpansion(mantissa.substring(12,15));
	
	                        String firstBCD = packedBCD(setOne);
	                        String secondBCD = packedBCD(setTwo);
	                        String thirdBCD = packedBCD(setThree);
	                        String fourthBCD = packedBCD(setFour);
	                        String fifthBCD = packedBCD(setFive);
	
	                        String fullBCD = firstBCD + secondBCD + thirdBCD + fourthBCD + fifthBCD;
	                        
	                        System.out.println("Your corrected input: " + input);
	
	                        System.out.println("Your floating point: " + signBit + " | " + combiField + " | " + exponent6 + " | " + fullBCD);
	
	                        String output = signBit + combiField + exponent6 + fullBCD;
	
	                        String hex0 = BinarytoHex(output.substring(0,4));
	                        String hex1 = BinarytoHex(output.substring(4,8));
	                        String hex2 = BinarytoHex(output.substring(8,12));
	                        String hex3 = BinarytoHex(output.substring(12,16));
	                        String hex4 = BinarytoHex(output.substring(16,20));
	                        String hex5 = BinarytoHex(output.substring(20,24));
	                        String hex6 = BinarytoHex(output.substring(24,28));
	                        String hex7 = BinarytoHex(output.substring(28,32));
	                        String hex8 = BinarytoHex(output.substring(32,36));
	                        String hex9 = BinarytoHex(output.substring(36,40));
	                        String hexA = BinarytoHex(output.substring(40,44));
	                        String hexB = BinarytoHex(output.substring(44,48));
	                        String hexC = BinarytoHex(output.substring(48,52));
	                        String hexD = BinarytoHex(output.substring(52,56));
	                        String hexE = BinarytoHex(output.substring(56,60));
	                        String hexF = BinarytoHex(output.substring(60,64));
	
	                        System.out.println("Converted to Hex: " + hex0+hex1+hex2+hex3+hex4+hex5+hex6+hex7+hex8+hex9+hexA+hexB+hexC+hexD+hexE+hexF);
	                        check = endingCase(check);
	                    }
                    }
                    else if(ruleChecking > 767) {
                    	if(signBit.equals("0")) {
                    	System.out.println("Your floating point: " + signBit + " | " + "11110" + " | " +  "00000000" + " | " + "00000000000000000000000000000000000000000000000000");
                    	System.out.println("Converted to Hex: " + "7800000000000000");
                    	System.out.println("THIS IS THE INFINITY SPECIAL CASE");
                    	check = true;
                    	}
                    	else {
                    	System.out.println("Your floating point: " + signBit + " | " + "11110" + " | " +  "00000000" + " | " + "00000000000000000000000000000000000000000000000000");
                        System.out.println("Converted to Hex: " + "F800000000000000");
                        System.out.println("THIS IS THE INFINITY SPECIAL CASE");
                        check = true;
                    	}
                    }
                    else if(input.equals("0000000000000000")) {
                    	System.out.println("Your floating point: " + "0 | 00000 | 00000000 | 00000000000000000000000000000000000000000000000000");
                    	System.out.println("Converted to Hex: " + "0000000000000000");
                    	System.out.println("THIS IS THE ZERO SPECIAL CASE");
                    	check = true;
                    }
                    else if(input.equals("") && ruleChecking < 0) {
                    	System.out.println("N/A");
                    }
            	}
            }

            else if (input.length() > 17) {
                System.out.println("PLEASE INPUT 16 DIGITS WITH OR WITHOUT A RADIX POINT.");
            }

        }
    }

    private String ePrimeBinary(int x) {
        String eString = "";
        x = x + 398;

        eString = Integer.toBinaryString(x);

        if(eString.length() < 10)
            for(int i = eString.length(); i<10; i++)
                eString = '0' + eString;

        return eString;
    }
    
    private boolean endingCase(boolean check) {
    	System.out.println("Would you like to run another decimal case?: ");
    	System.out.println("Only input Y or N");
    	Scanner input = new Scanner(System.in);
    	String choice = input.nextLine();
    	if(choice == "Y" || choice == "y")
    		check = false;
    	else if(choice == "N" || choice == "n")
    		check = true;
    	
    	return check;
    }

    private String BinarytoHex(String x) {

        String bin = "";

        if(x.equals("0000"))
            bin = "0";

        else if(x.equals("0001"))
            bin = "1";

        else if(x.equals("0010"))
            bin = "2";

        else if(x.equals("0011"))
            bin = "3";

        else if(x.equals("0100"))
            bin = "4";

        else if(x.equals("0101"))
            bin = "5";

        else if(x.equals("0110"))
            bin = "6";

        else if(x.equals("0111"))
            bin = "7";

        else if(x.equals("1000"))
            bin = "8";

        else if(x.equals("1001"))
            bin = "9";

        else if(x.equals("1010"))
            bin = "A";

        else if(x.equals("1011"))
            bin = "B";

        else if(x.equals("1100"))
            bin = "C";

        else if(x.equals("1101"))
            bin = "D";

        else if(x.equals("1110"))
            bin = "E";

        else if(x.equals("1111"))
            bin = "F";

        return bin;
    }

    private String DectoBinary(char x) {

        String bin = "0000";

        if(x == '0')
            bin = "0000";

        else if(x == '1')
            bin = "0001";

        else if(x == '2')
            bin = "0010";

        else if(x == '3')
            bin = "0011";

        else if(x == '4')
            bin = "0100";

        else if(x == '5')
            bin = "0101";

        else if(x == '6')
            bin = "0110";

        else if(x == '7')
            bin = "0111";

        else if(x == '8')
            bin = "1000";

        else if(x == '9')
            bin = "1001";

        return bin;
    }

    private String binaryExpansion(String e) {
        String x0 = DectoBinary(e.charAt(0));
        String x1 = DectoBinary(e.charAt(1));
        String x2 = DectoBinary(e.charAt(2));

        String set = x0 + x1 + x2;

        return set;
    }

    private String packedBCD(String e) {
        String BCD = "";
        String b = Character.toString(e.charAt(1)); String c = Character.toString(e.charAt(2)); String d = Character.toString(e.charAt(3)); String f = Character.toString(e.charAt(5));
        String g = Character.toString(e.charAt(6)); String h = Character.toString(e.charAt(7)); String j = Character.toString(e.charAt(9)); String k = Character.toString(e.charAt(10));
        String m = Character.toString(e.charAt(11));
        String a = Character.toString(e.charAt(0)); String ee = Character.toString(e.charAt(4)); String i = Character.toString(e.charAt(8)); //Had to be double e for syntax
        int a1 = Integer.parseInt(a); int e1 = Integer.parseInt(ee); int i1 = Integer.parseInt(i);
        if(a1 == 0 && e1 == 0 && i1 == 0) {
            BCD = b + c + d + f + g + h + 0 + j + k + m;
        }
        else if(a1 == 0 && e1 == 0 && i1 == 1) {
            BCD = b + c + d + f + g + h + "1" + "0" + "0" + m;
        }
        else if (a1 == 0 && e1 == 1 && i1 == 0) {
            BCD = b + c + d + j + k + h + "1" + "0" + "1" + m;
        }
        else if(a1 == 0 && e1 == 1 && i1 == 1) {
            BCD = b + c + d + "1" + "0" + h + "1" + "1" + "1" + m;
        }
        else if(a1 == 1 && e1 == 0 && i1 == 0) {
            BCD = j + k + d + f + g + h + "1" + "1" + "0" + m;
        }
        else if(a1 == 1 && e1 == 0 && i1 == 1) {
            BCD = f + g + d + "0" + "1" + h + "1" + "1" + "1" + m;
        }
        else if(a1 == 1 && e1 == 1 && i1 == 0) {
            BCD = j + k + d + "0" + "0" + h + "1" + "1" + "1" + m;
        }
        else if(a1 == 1 && e1 == 1 && i1 == 1) {
            BCD = "0" + "0" + d + "1" + "1" + h + "1" + "1" + "1" + m;
        }
        return BCD;
    }

}

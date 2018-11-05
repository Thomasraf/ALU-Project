import java.util.*;
public class Input {
	private String floatingPoint;
	
	String getfloatingPoint() {
		return floatingPoint;
	}
	
	public void setfloatingPoint(String floatingPoint) {
		this.floatingPoint = floatingPoint;
	}
	
	public void Conversion() {
		System.out.println("What Decimal and Base 10 would you like to convert?: ");
		System.out.println("EXAMPLE INPUT -> 7123456555777666x10^2");
				Scanner input = new Scanner(System.in);
				this.setfloatingPoint(input.nextLine());
				
				String[] half = this.getfloatingPoint().split("x");
				String half1 = half[0]; //7123456555777666 or 7123456.8976
				String half2 = half[1]; //10^7
				
				String base[] = half2.split("\\^");
				String base1 = base[0]; //10
				String base2 = base[1]; //7
				
				if(this.getfloatingPoint().contains("x") == true && half1.matches("[01]+") && !half1.startsWith("0")
						&& half1.length() == 16) { //to check if a base was inputed and if the input was decimal, and NOT binary
					if(this.getfloatingPoint().charAt(0) != '-') { //positive sign bit 
						if(half1.contains("\\.") == true) { //This is for decimal inputs that have a radix point
							int total = half1.length(); //This gets the total amount of how long the string is so 7123456.8976 total is 12(including '.')
							int index = half1.indexOf('.'); //This gets the index of the '.' which is 7 in this case
							int adder = (total - 1) - index; //So it will be 11 - 7	
							
							String true_half1 = movingDecimal(half1, index); //Simply moving the decimal
							
							if(true_half1.length() != 15) { //This is to place the 0's in front of the number if it is not already 16
								true_half1 = placingZero(true_half1);
							}
							char stringMSD = true_half1.charAt(0); // 7
							int MSD = Integer.parseInt(String.valueOf(stringMSD));
							
							base2 = eSpecial(base2, adder); //This is simply E' = E + 398 but placed in a function to make it cleaner, but with the addition of a moved decimal point 
							String finalMSD = Integer.toBinaryString(MSD);
							
								if(MSD < 8) { //This is finalizing this part of the section
									String x0 = Character.toString(base2.charAt(0)); String x1 = Character.toString(base2.charAt(1)); String x2 = Character.toString(finalMSD.charAt(1)); 
									String x3 = Character.toString(finalMSD.charAt(2));	String x4 = Character.toString(finalMSD.charAt(3));
									String combinationField = x0 + x1 + x2 + x3 + x4; //To add all the bits but I'm sorry if it's brute force
									
									String e1 = Character.toString(base2.charAt(2)); String e2 = Character.toString(base2.charAt(3)); String e3 = Character.toString(base2.charAt(4));
									String e4 = Character.toString(base2.charAt(5)); String e5 = Character.toString(base2.charAt(6));
									
									String Exponent = (e1 + e2 + e3 + e4 + e5);	

									String firstSet[] = {Character.toString(true_half1.charAt(1)), Character.toString(true_half1.charAt(2)), Character.toString(true_half1.charAt(3))};
									String secondSet[] = {Character.toString(true_half1.charAt(4)), Character.toString(true_half1.charAt(5)), Character.toString(true_half1.charAt(6))};
									String thirdSet[] = {Character.toString(true_half1.charAt(7)), Character.toString(true_half1.charAt(8)), Character.toString(true_half1.charAt(9))};
									String fourthSet[] = {Character.toString(true_half1.charAt(10)), Character.toString(true_half1.charAt(11)), Character.toString(true_half1.charAt(12))};
									String fifthSet[] = {Character.toString(true_half1.charAt(13)), Character.toString(true_half1.charAt(14)), Character.toString(true_half1.charAt(15))};
									
									String setOne = binaryExpansion(firstSet);
									String setTwo = binaryExpansion(secondSet);
									String setThree = binaryExpansion(thirdSet);
									String setFour = binaryExpansion(fourthSet);
									String setFive = binaryExpansion(fifthSet);
									
									String firstBCD = packedBCD(setOne);
									String secondBCD = packedBCD(setTwo);
									String thirdBCD = packedBCD(setThree);
									String fourthBCD = packedBCD(setFour);
									String fifthBCD = packedBCD(setFive);
									
									System.out.println("Your final output!: ");
									System.out.print(0 + "|" +  combinationField + "|" + Exponent + "|" + firstBCD + "|" + secondBCD + "|" + thirdBCD + "|" + fourthBCD + "|" + fifthBCD);
								}
								else if(MSD == 8 || MSD == 9) { //This is finalizing this part of the section
									String x2 = Character.toString(finalMSD.charAt(1)); 
									String x3 = Character.toString(finalMSD.charAt(2));	String x4 = Character.toString(finalMSD.charAt(3));
									String combinationField = 1 + 1 + x2 + x3 + x4;
									
									String e1 = Character.toString(base2.charAt(2)); String e2 = Character.toString(base2.charAt(3)); String e3 = Character.toString(base2.charAt(4));
									String e4 = Character.toString(base2.charAt(5)); String e5 = Character.toString(base2.charAt(6));
									
									String Exponent = (e1 + e2 + e3 + e4 + e5);	

									String firstSet[] = {Character.toString(true_half1.charAt(1)), Character.toString(true_half1.charAt(2)), Character.toString(true_half1.charAt(3))};
									String secondSet[] = {Character.toString(true_half1.charAt(4)), Character.toString(true_half1.charAt(5)), Character.toString(true_half1.charAt(6))};
									String thirdSet[] = {Character.toString(true_half1.charAt(7)), Character.toString(true_half1.charAt(8)), Character.toString(true_half1.charAt(9))};
									String fourthSet[] = {Character.toString(true_half1.charAt(10)), Character.toString(true_half1.charAt(11)), Character.toString(true_half1.charAt(12))};
									String fifthSet[] = {Character.toString(true_half1.charAt(13)), Character.toString(true_half1.charAt(14)), Character.toString(true_half1.charAt(15))};
									
									String setOne = binaryExpansion(firstSet);
									String setTwo = binaryExpansion(secondSet);
									String setThree = binaryExpansion(thirdSet);
									String setFour = binaryExpansion(fourthSet);
									String setFive = binaryExpansion(fifthSet);
									
									String firstBCD = packedBCD(setOne);
									String secondBCD = packedBCD(setTwo);
									String thirdBCD = packedBCD(setThree);
									String fourthBCD = packedBCD(setFour);
									String fifthBCD = packedBCD(setFive);
									
									System.out.println("Your final output!: ");
									System.out.print(0 + "|" +  combinationField + "|" + Exponent + "|" + firstBCD + "|" + secondBCD + "|" + thirdBCD + "|" + fourthBCD + "|" + fifthBCD);
								}
						}
						
						else { //This is for decimals WITHOUT a radix point
							int total = half1.length(); //This gets the total amount of how long the string is so 7123456.8976 total is 12(including '.')
							int index = half1.indexOf('.'); //This gets the index of the '.' which is 7 in this case
							int adder = (total - 1) - index; //So it will be 11 - 7	
							
							String true_half1 = movingDecimal(half1, index);
							
							char stringMSD = true_half1.charAt(0); // 7
							int MSD = Integer.parseInt(String.valueOf(stringMSD));
							
							base2 = e(base2);
							String finalMSD = Integer.toBinaryString(MSD);
							
							if(MSD < 8) { //This is finalizing this part of the section
								String x0 = Character.toString(base2.charAt(0)); String x1 = Character.toString(base2.charAt(1)); String x2 = Character.toString(finalMSD.charAt(1)); 
								String x3 = Character.toString(finalMSD.charAt(2));	String x4 = Character.toString(finalMSD.charAt(3));
								String combinationField = x0 + x1 + x2 + x3 + x4; //To add all the bits but I'm sorry if it's brute force
							}
							else if(MSD == 8 || MSD == 9) { //This is finalizing this part of the section
								String x2 = Character.toString(finalMSD.charAt(1)); 
								String x3 = Character.toString(finalMSD.charAt(2));	String x4 = Character.toString(finalMSD.charAt(3));
								String combinationField = 1 + 1 + x2 + x3 + x4;
							}
						String e1 = Character.toString(base2.charAt(2)); String e2 = Character.toString(base2.charAt(3)); String e3 = Character.toString(base2.charAt(4));
						String e4 = Character.toString(base2.charAt(5)); String e5 = Character.toString(base2.charAt(6));
							
						String Exponent = (e1 + e2 + e3 + e4 + e5);	
						}
//						if(MSD < 8) { //If MSD is less than 8 or 9 rule
							
//							if(half1.contains("\\.") == true) { //this is if the input has a "." which we have to move to increase the exponent count (712345655577.7666)
//								int total = half1.length(); //This gets the total amount of how long the string is so 7123456.8976 total is 12(including '.')
//								int index = half1.indexOf('.'); //This gets the index of the '.' which is 7 in this case
//								int adder = (total - 1) - index; 	
//								
//								String true_half1 = movingDecimal(half1, index); //This is to move the decimal point to the end 
//								true_half1.replace("\\.", ""); //This is to remove the decimal point at the end
//								
//								
//								
//								eSpecial(base2, adder); //This is simply E' = E + 398 but placed in a function to make it cleaner, but with the addition of a moved decimal point 
//								String finalMSD = Integer.toBinaryString(MSD);
//								String x0 = Character.toString(base2.charAt(0)); String x1 = Character.toString(base2.charAt(1)); String x2 = Character.toString(finalMSD.charAt(1)); 
//								String x3 = Character.toString(finalMSD.charAt(2));	String x4 = Character.toString(finalMSD.charAt(3));
//								String combinationField = x0 + x1 + x2 + x3 + x4; //To add all the bits but I'm sorry if it's brute force
//								
//								
//								}
//							
//							else { //If this is the input 7123456555777666
//								e(base2); //This is simply E' = E + 398 but placed in a function to make it cleaner
//								String finalMSD = Integer.toBinaryString(MSD);
//								String x0 = Character.toString(base2.charAt(0)); String x1 = Character.toString(base2.charAt(1)); String x2 = Character.toString(finalMSD.charAt(1)); 
//								String x3 = Character.toString(finalMSD.charAt(2));	String x4 = Character.toString(finalMSD.charAt(3));
//								String combinationField = x0 + x1 + x2 + x3 + x4; //To add all the bits but I'm sorry if it's brute force
//							}
								
						
						} //This is where the positive sign bit ends
					}
				
				
					
			}



	public String e(String base2) { //For 7123456555777666 inputs 
		int i = Integer.parseInt(base2);
		int ePrime = i + 398; 
		String ePrimeBinary = Integer.toBinaryString(ePrime); //01101100
		return ePrimeBinary; 
	}
	
	public String eSpecial(String base2, int adder) { //For 712345655577.7666 inputs
		int i = Integer.parseInt(base2);
		int ePrime = i + 398 + adder; 
		String ePrimeBinary = Integer.toBinaryString(ePrime); //01101100
		return ePrimeBinary; 
	}
	
	private String movingDecimal(String half1, int index) {
		int decimal = Integer.parseInt(half1);
		for(int i = 0; i < 4; i++) {
			decimal = decimal * 10;
		}
		String newHalf1 = Integer.toString(decimal);
		newHalf1.replace("\\.", "");
		return newHalf1;
	}
	
	private String placingZero(String x) {
		while(x.length() != 15) {
			x = 0 + x;
		}
		return x;
	}
	
	private String binaryExpansion(String e[]) {
		int first = Integer.parseInt(e[0]); //from String 0 it will become int 0
		int second = Integer.parseInt(e[1]);
		int third = Integer.parseInt(e[2]);
		
		String x0 = Integer.toBinaryString(first); //From 0 it will become 0000
		String x1 = Integer.toBinaryString(second);
		String x2 = Integer.toBinaryString(third);
		
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
				BCD = b + c + d + f + g + h + 1 + 0 + 0 + m;
			}
			else if (a1 == 0 && e1 == 1 && i1 == 0) {
				BCD = b + c + d + j + k + h + 1 + 0 + 1 + m;
			}
			else if(a1 == 0 && e1 == 1 && i1 == 1) {
				BCD = b + c + d + 1 + 0 + h + 1 + 1 + 1 + m;
			}
			else if(a1 == 1 && e1 == 0 && i1 == 0) {
				BCD = j + k + d + f + g + h + 1 + 1 + 0 + m;
			}
			else if(a1 == 1 && e1 == 0 && i1 == 1) {
				BCD = f + g + d + 0 + 1 + h + 1 + 1 + 1 + m;
			}
			else if(a1 == 1 && e1 == 1 && i1 == 0) {
				BCD = j + k + d + 0 + 0 + h + 1 + 1 + 1 + m;
			}
			else if(a1 == 1 && e1 == 1 && i1 == 1) {
				BCD = 0 + 0 + d + 1 + 1 + h + 1 + 1 + 1 + m;
			}
		return BCD;
	}
	
}
import java.util.*;
public class Input {
	private String floatingPoint;
	private boolean found = false;

	String getfloatingPoint() {
		return floatingPoint;
	}
	
	public void setfloatingPoint(String floatingPoint) {
		this.floatingPoint = floatingPoint;
	}
	
	public void Conversion() {
		System.out.println("What Decimal and Base 10 would you like to convert?: ");
		System.out.println("EXAMPLE INPUT -> 7123456555777666x10^2");
			while(found != true) {
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
						char stringMSD = half1.charAt(0); // 7
						int MSD = Integer.parseInt(String.valueOf(stringMSD));
						
						if(MSD < 8) { //If MSD is less than 8 or 9 rule
							
							if(half1.contains("\\.") == true) { //this is if the input has a "." which we have to move to increase the exponent count (712345655577.7666)
								int total = half1.length(); //This gets the total amount of how long the string is so 7123456.8976 total is 12(including '.')
								int index = half1.indexOf('.'); //This gets the index of the '.' which is 7 in this case
								int adder = (total - 1) - index; //So it will be 11 - 7		
								
								eSpecial(base2, adder);
								String finalMSD = Integer.toBinaryString(MSD);
								String x0 = Character.toString(base2.charAt(0)); String x1 = Character.toString(base2.charAt(1)); String x2 = Character.toString(finalMSD.charAt(1)); 
								String x3 = Character.toString(finalMSD.charAt(2));	String x4 = Character.toString(finalMSD.charAt(3));
								String combinationField = x0 + x1 + x2 + x3 + x4; //To add all the bits but I'm sorry if it's brute force
								}
							
							else { //If this is the input 7123456555777666
								e(base2);
								String finalMSD = Integer.toBinaryString(MSD);
								String x0 = Character.toString(base2.charAt(0)); String x1 = Character.toString(base2.charAt(1)); String x2 = Character.toString(finalMSD.charAt(1)); 
								String x3 = Character.toString(finalMSD.charAt(2));	String x4 = Character.toString(finalMSD.charAt(3));
								String combinationField = x0 + x1 + x2 + x3 + x4; //To add all the bits but I'm sorry if it's brute force
							}
								
						}
					}
				}
				
					
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
	
}

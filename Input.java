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
				String half1 = half[0]; //7123456555777666
				String half2 = half[1]; //10^7
				String base[] = half2.split("\\^");
				String base1 = base[0]; //10
				String base2 = base[1]; //7
				
				if(this.getfloatingPoint().contains("x") == true && half1.matches("[01]+") && !half1.startsWith("0")
						&& half1.length() == 16) { //to check if a base was inputed and if it is not binary
					if(this.getfloatingPoint().charAt(0) != '-') { //positive sign bit 
						char stringMSD = half1.charAt(0); // 7
						int MSD = Integer.parseInt(String.valueOf(stringMSD));
						if(MSD < 8) { //If MSD is less than 8 rule
							e(base2);
							String finalMSD = Integer.toBinaryString(MSD);
							String x0 = Character.toString(base2.charAt(0)); String x1 = Character.toString(base2.charAt(1)); String x2 = Character.toString(finalMSD.charAt(1)); String x3 = Character.toString(finalMSD.charAt(2));
							String x4 = Character.toString(finalMSD.charAt(3));
							String combinationField = x0 + x1 + x2 + x3 + x4; //To add all the bits but I'm sorry if it's brute force
						}
					}
				}
				
					
			}
	}



	public String e(String base2) {
		int i = Integer.parseInt(base2);
		int ePrime = i + 398; //108 
		String ePrimeBinary = Integer.toBinaryString(ePrime); //01101100
		return ePrimeBinary; 
	}
	
}

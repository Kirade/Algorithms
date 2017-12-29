public class RandomString {
	private static String pattern = "[a-zA-Z0-9]+$";
	private static StringBuffer returnString = null;

	//Overload Constructor
	public RandomString() { returnString = new StringBuffer(); }
	public RandomString(int len) { returnString = new StringBuffer(); this.setLength(len); }
	public RandomString(String type) { returnString = new StringBuffer(); this.setType(type); }
	public RandomString(int len, String type) { returnString = new StringBuffer(); this.setLength(len); this.setType(type); }
	public RandomString(String type, int len) { returnString = new StringBuffer(); this.setType(type); this.setLength(len); }

	//Get Random Character
	private static void getRndChar() {
		int r = (int)Math.round(Math.random() * 1000);

		java.util.Random random = new java.util.Random();
		int rnd = random.nextInt(1000);

		if(test(pattern, String.valueOf((char)rnd))) {
			returnString.append((char)rnd);
		} else {
			getRndChar();
		}
	}



	//Regular Express Check Function
	private static boolean test(String pattern, String value) {
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
		java.util.regex.Matcher m = p.matcher(value);
		boolean r = m.matches();

		return r;
	}



	//Set String Length
	public void setLength(int len) {
		returnString.setLength(0);
		for(int i=0; i<Math.abs(len); i++) {
			getRndChar();
		}
	}



	//Set String Pattern Type
	public void setType(String type) {
		if(type.equals("1")) pattern = "[0-9]+$";
		else if(type.equals("A")) pattern = "[A-Z]+$";
		else if(type.equals("a")) pattern = "[a-z]+$";
		else if(type.equals("A1")) pattern = "[A-Z0-9]+$";
		else if(type.equals("a1")) pattern = "[a-z0-9]+$";
		else pattern = "[a-zA-Z0-9]+$";
	}



	//Get Random String
	public String getString() {
		return returnString.toString();
	}



	//Overload getString()
	public String getString(int len, String type) {
		this.setType(type);
		this.setLength(len);
		return this.getString();
	}
}

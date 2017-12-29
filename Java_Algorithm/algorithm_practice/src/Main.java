import java.util.*;

public class Main {
	public static void main(String[] args) {
		RandomString rndStr = new RandomString();
		String input = rndStr.getString(100,"");
//		String input = "abccdabc";

		ZumInternet algo = new ZumInternet(input);
		String result = algo.algorithm();
		System.out.println(input);
		System.out.print(result);


	}


}




import java.util.*;

public class zum_1 {
	public zum_1(){
	}

	int count;

	public String solution(int A, int B) {

		int R;
		int remain;
		String remain_str;


		if(A > B){
			R = A/B;
			remain = A%B;
			if(remain == 0){
				return String.valueOf(R);
			}else {
				remain_str = recur(remain, B, count++);
			}
		}else if(A < B){
			R = 0;
			remain = A;
			remain_str = recur(remain, B, count++);
		}else{
			return "1";
		}

		int nonzero=0;
		while(remain_str.charAt(nonzero) == '0'){
			nonzero++;
		}

		for(int i=nonzero; i<remain_str.length()/2; i++){
			for(int j=i+1; j<remain_str.length(); j++) {
				String temp1 = remain_str.substring(i, j);

				if(j+j-i < remain_str.length()) {
					String temp2 = remain_str.substring(j, j+j-i);

					if (temp1.equals(temp2)) {
						String front = remain_str.substring(0,i);

						remain_str = front+"("+temp1+")";
						break;
					}
				}

			}
		}

		return R+"."+remain_str;
	}

	private String recur(int a, int b, int count){
		if(count > 30){
			return "";
		}
		// a 는 b 보다 작은 수

		StringBuilder sb = new StringBuilder();

		do{
			a *= 10;
			if(a<b){
				sb.append("0");
			}
		}while(a<b);

		if(a == b){
			sb.append("1");
			return sb.toString();
		}else{
			// a>b
			int d = a/b;
			int r = a%b;
			sb.append(String.valueOf(d));

			if(r != 0)
				sb.append(recur(r,b,count+1));
		}

		return sb.toString();
	}

}

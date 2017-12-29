import java.util.regex.Pattern;
import java.util.*;

public class ZumInternet {

	private static final String regex = "(^[a-zA-Z0-9]+$)";
	private static String input;
	private static int M = -1;
	private static String M_String = "";
	private static int M_value = 0;

	// Constructor
	public ZumInternet(String input){
		this.input = input;
	}

	// Process Algorithm
	public String algorithm(){
		if(!Pattern.matches(regex, input))
			System.exit(1);


		// 문자열 갯수
		for(int i=1; i<input.length()/2; i++){
			HashMap<String, Integer> hashmap = new HashMap<>();
			ArrayList<String> arr = new ArrayList<>();

			// 문자열 탐색 갯수만큼 나누어 arr에 넣기
			for(int begin=0; begin + i <=input.length(); begin++) {
				if(begin+i == input.length()){
					arr.add(input.substring(begin));
				}else {
					arr.add(input.substring(begin, begin + i));
				}
			}


			// 해쉬 함수를 통해 해쉬 생성 & 해쉬맵 초기화
			int[] hash_value = new int[arr.size()];

			for(int j=0; j<arr.size(); j++) {
				hash_value[j] = hash(arr.get(j));
				hashmap.put(arr.get(j), 0);
			}

			// 원소 하나씩 돌면서 포함여부 판단
			for(int j=0; j<hash_value.length; j++){
				int count = 1;
				for(int k=j+i; k<hash_value.length; k++){
					if(hash_value[j]==hash_value[k]){
						if(check(arr.get(j), arr.get(k))){
							// 매칭 개수 카운트
							count++;
							k += i-1;
						}
					}
				}
				// count 보다 해쉬맵의 카운트 갯수가 작으면 추가 ( 나중에 체크하는 것들 중복 방지 )
				if(hashmap.get(arr.get(j)) < count){
					hashmap.put(arr.get(j), count);
				}
			}


			for(Map.Entry<String, Integer> entry : hashmap.entrySet()){
				String key = entry.getKey();
				Integer value = entry.getValue();
				int temp;
				if(value >= 2) {
					temp = key.length() * value;
				}else{
					temp = 0;
				}
				if(temp > M){
					M = temp;
					M_String = key;
					M_value = value;
				}
				else if(temp == M){
					if(M_String.length() > key.length()){
						M = temp;
						M_String = key;
						M_value = value;
					}
				}
			}


		}
		if(M == 0){
			return "NULL";
		}else {
			return M_String + ":" + M_value;
		}
	}



	private static int hash(String str){
		int sum = 0;
		for(char c : str.toCharArray())
			sum += (int)c;

		return sum;
	}

	private static boolean check(String str1, String str2){
		return str1.equals(str2);
	}

}

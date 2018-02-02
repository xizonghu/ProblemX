
public class FlyB {
	public static String f(String str) {
		String res = new String();
		for(int i = 0; i < str.length(); i++) {
			res += String.valueOf((char)('z' - str.charAt(i) + 'a'));
		}
		return res;
	}

	public static String g(String str) {
		str = str.toLowerCase().replace(" ", "");
		String res = "{\n";
		int [] arr = new int [26];
		for(int i = 0; i < arr.length; i++) arr[i] = 0;
		for(int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'a']++;
		}
		for(int i = 0; i < arr.length; i++) {
			res += String.valueOf((char)('a' + i)) + ":" + String.valueOf(arr[i]) + "\n";
		}
		res += "}";
		return res;
	}
	public static void main(String[] args) {
		String res = f("acp");
		System.out.printf("res = %s\n", res);
		res = g("Hello Apple");
		System.out.printf("res = %s\n", res);
	}
}

package calendar;

import java.util.Scanner; // cmd + shift + m

public class Sum {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("두 수를 입력하세요.");
		
		// 방법 1
		String s1 = scanner.next();
		String s2 = scanner.next();
		
		int a = Integer.parseInt(s1);
		int b = Integer.parseInt(s2);
		
		// 방법 2
//		String num = scanner.nextLine();
//		String [] SplitedValue = num.split(" ");
		
//		int a = Integer.parseInt(SplitedValue[0]);
//		int b = Integer.parseInt(SplitedValue[1]);
		
		
//		System.out.println("두 수의 합은 " + (a+b) + "입니다.");
//		System.out.printf("두 수의 합은 %d입니다.", a + b);
		System.out.printf("%d와 %d의 합은 %d입니다.", a, b, a + b);
		scanner.close();
	}

}

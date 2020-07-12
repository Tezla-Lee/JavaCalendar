package calendar;
import java.util.Scanner;
public class Sum {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("두 수를 입력하세요.");
//		int a = scanner.nextInt();
//		int b = scanner.nextInt();
		
		String num = scanner.nextLine();
		String [] SplitedValue = num.split(" ");
		
		int a = Integer.parseInt(SplitedValue[0]);
		int b = Integer.parseInt(SplitedValue[1]);
		
		
		System.out.println("두 수의 합은 " + (a+b) + "입니다.");
	}

}

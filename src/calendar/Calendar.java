package calendar;

public class Calendar {

	public static void main(String[] args) {

		System.out.println("Hello, Calendar");
		String s;
		
		System.out.println(" 일  월  화  수  목  금  토");
		System.out.println("--------------------------");

		for (int day = 1; day <= 31; day++) {
			s = Integer.toString(day);
			if (s.length() == 1) {
				System.out.print(" ");
			}
			System.out.print(day);
			System.out.print("  ");
			if (day % 7 == 0) {
				System.out.println();
			}
		}
	}

}

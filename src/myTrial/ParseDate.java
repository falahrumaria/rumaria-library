package myTrial;

public class ParseDate {

	public static void main(String[] args) {
		String dateIndonesia = "18-10-2012";
		System.out.println(dateIndonesia);
		String dateInter = parseDateToInterFormat(dateIndonesia);
		System.out.println(dateInter);
		
		int[] arr = new int[4];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}
	}

	public static String parseDateToIndonesianFormat(String dateInter) {
		String year = "";
		String month = "";
		String day = "";
		char[] dateChar = dateInter.toCharArray();

		for (int i = 0; i < 4; i++) {
			year += dateChar[i];
		}
		for (int i = 5; i < 7; i++) {
			month += dateChar[i];
		}
		for (int i = 8; i < 10; i++) {
			day += dateChar[i];
		}

		return (day + "/" + month + "/" + year);
	}
	
	public static String parseDateToInterFormat(String dateIndo) {
		String year = "";
		String month = "";
		String day = "";
		char[] dateChar = dateIndo.toCharArray();

		for (int i = 0; i < 2; i++) {
			day += dateChar[i];
		}
		for (int i = 3; i < 5; i++) {
			month += dateChar[i];
		}
		for (int i = 6; i < 10; i++) {
			year += dateChar[i];
		}

		return (year + "-" + month + "-" + day);
	}
}

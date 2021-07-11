
/**
 * Student class represents a single student from the directory 
 * and holds all the directory information for that student.
 * 
 * @author Edwin Sanchez Huizar
 *
 */
public class Student {

	private String fullName;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	private int suBox;

	public static String[] studentInfo;
	public static String[] studentName;

	/**
	 * the student constructor takes in a single line of the information from directory text,
	 * splits the line and assigns the value to the corresponding instance variable.
	 * 
	 * @param line by line information of a student from the directory text
	 */
	public Student(String student) {

		studentInfo = student.split("\\|");

		studentName = studentInfo[0].split(" ");
		firstName = studentName[0];
		lastName = studentName[1];

		fullName = firstName + " " + lastName;
		address = studentInfo[1];
		phoneNumber = studentInfo[2];
		email = studentInfo[3];
		suBox = Integer.parseInt(studentInfo[4].trim());
	}

	/**
	 * The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. Thus, the 
	 * the student's fullName is declared as a private attribute and the get method allows the user to
	 * access the private variable.
	 * 
	 * @return full name of the student
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. Thus, the 
	 * the student's firstName is declared as a private attribute and the get method allows the user to
	 * access the private variable.
	 * 
	 * @return first name of the student
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. Thus, the 
	 * the student's lastName is declared as a private attribute and the get method allows the user to
	 * access the private variable.
	 * 
	 * @return last name of the student
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. Thus, the 
	 * the student's address is declared as a private attribute and the get method allows the user to
	 * access the private variable.
	 * 
	 * @return address of the student
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. Thus, the 
	 * the student's phoneNumber is declared as a private attribute and the get method allows the user to
	 * access the private variable.
	 * 
	 * @return phone number of the student
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. Thus, the 
	 * the student's email is declared as a private attribute and the get method allows the user to
	 * access the private variable.
	 * 
	 * @return email of the student
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. Thus, the 
	 * the student's suBox is declared as a private attribute and the get method allows the user to
	 * access the private variable.
	 * 
	 * @return SU box number of the student
	 */
	public int getSUBox() {
		return suBox;
	}

	/**
	 * the getVowels method counts the total number of vowels in the student's first and last name,
	 * this information is given in the instance variable fullName.
	 * 
	 * @return total number of vowels in a student's full name
	 */
	public int getVowels() {

		int vowelCount = 0;
		char[] letters = fullName.toLowerCase().toCharArray();
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		for(int i = 0; i < letters.length; i++){
			for(int j = 0; j < vowels.length; j++){
				if(letters[i]==vowels[j]){
					vowelCount += 1;
				}
			}
		}
		return vowelCount;
	}

	/**
	 * the getDigit method counts the total frequency of any single digit in a student's phone number. 
	 * frequency integer array stores the corresponding frequency of any digit to the index 
	 * 
	 * @return the maximum frequency of a single digit student has
	 */
	public int getDigit() {

		//index is the digit, value is the digit frequency
		int[] frequency = new int[10];

		int maxCount = 0;

		//create frequency integer array
		if(getPhoneNumber() != "?") {
			for(int i = 0; i < getPhoneNumber().length(); i++) {
				char digit = getPhoneNumber().charAt(i);
				if(Character.getNumericValue(digit) != -1) {
					frequency[Character.getNumericValue(digit)] ++;
				}
			}
		}
		//find the maximum frequency of any digit 
		for(int freq: frequency) {
			if(freq > maxCount) {
				maxCount = freq;
			}
		}
		return maxCount;
	}

	public String toString() {
		return firstName + " " + lastName + " | " + address + " | " + phoneNumber + " | " + email + " | " + suBox + "\n";
	}
}


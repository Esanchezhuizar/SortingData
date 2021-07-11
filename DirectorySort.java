import java.io.File;
import java.util.Comparator;
import java.util.Scanner;

/**
 * DrirectorySort class will: 
 * 		read a Bowdoin College student directory data set file, 
 * 		create student objects from the file,
 * 		construct a SortableArrayList of all the student objects, 
 * 		defines comparators needed to answer questions,
 * 		sort the SortableArrayList in response to the questions.
 * 
 * @author Edwin Sanchez Huizar
 *
 */
public class DirectorySort {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		SortableArrayList<Student> directory = new SortableArrayList<Student>();

		//read the directory file
		try {
			File fileName = new File("directory.txt");
			scan = new Scanner(fileName);
		}
		catch (Exception e) {
			// failed to read file -- print error and exit/return
			System.out.println("An error occurred");
			System.exit(0);
		}
		//read the file into line-by-line and create a new Student object for every line
		while(scan.hasNext()) {		
			String line = scan.nextLine();
			Student newStudent = new Student(line);
			directory.add(newStudent);
		}
		scan.close();

		directory.sort(new SUBoxComparator());
		System.out.println("Smallest SU Box: " + directory.get(0)); 
		System.out.println("Largest SU Box : " + directory.get(directory.size()-1)); 

		System.out.println();

		directory.sort(new LastNameComparator());
		System.out.println("First student ordered by Lastname: " + directory.get(0)); 
		System.out.println("Last student ordered by Lastname: " + directory.get(directory.size()-1)); 

		System.out.println();

		directory.sort(new VowelComparator());
		System.out.println("Student with fewest vowels: " + directory.get(0)); 
		System.out.println("Student with most vowels: " + directory.get(directory.size()-1)); 

		System.out.println();
		directory.sort(new DigitComparator());
		System.out.println("Student with fewest digits: " + directory.get(0)); 
		System.out.println("Student with most digits: " + directory.get(directory.size()-1)); 
	}

	/**
	 * Comparator interface is used to order the objects of user-defined classes.
	 * The comparator object compares two objects of two different student classes 
	 * with respects to their SU boxes.
	 * 
	 * @author Edwin Sanchez Huizar
	 */
	private static class SUBoxComparator implements Comparator<Student> {

		/**
		 * Compares to students with respect to their SU box by using the getSUBox method.
		 * Returns -, 0, or + if student a has a smaller/equal to/bigger SU Box than student b, respectively.
		 */
		public int compare(Student a, Student b) {
			return a.getSUBox() - b.getSUBox();
		}
	}

	/**
	 * Comparator interface is used to order the objects of user-defined classes.
	 * The comparator object compares two objects of two different student classes 
	 * with respects to their last name.
	 *
	 * @author Edwin Sanchez Huizar
	 */
	private static class LastNameComparator implements Comparator<Student> {

		/**
		 * The getLastName method gets the students last name. The toLowerCase() string method 
		 * converts all characters of the last name into lower case letters given that ASCII
		 * differences (between a capital and lower case letter) would affect the output.
		 * Returns -,0, or + if student a's last name is lexicographically less than, equal to, 
		 * or greater than student b's last name, respectively. 
		 */
		public int compare(Student a, Student b) {
			return a.getLastName().toLowerCase().compareTo(b.getLastName().toLowerCase());		
		}
	}

	/**
	 * Comparator interface is used to order the objects of user-defined classes.
	 * The comparator object compares two objects of two different student classes
	 * with respect to the # of vowels in their full name.
	 * 
	 * @author Edwin Sanchez Huizar 
	 */
	private static class VowelComparator implements Comparator<Student>{

		/**
		 * The getVowels() method counts the total number of vowels in the student's first
		 * and last name. Returns -, 0, or + if student a's full name has less/equal/more vowels 
		 * than student b's full name.
		 */
		public int compare(Student a, Student b) {
			return a.getVowels() - b.getVowels();
		}
	}

	/**
	 * Comparator interface is used to order the objects of user-defined classes.
	 * The comparator object compares two objects of two different student classes with respects
	 * to number of digits in their phone number.
	 * 
	 * @author Edwin Sanchez Huizar
	 *
	 */
	private static class DigitComparator implements Comparator<Student>{

		/**
		 * The getDigit() method counts the total frequency of any single digit in a student's phone number.
		 * Returns -, 0, or + if student a's phone number has less/equal/greater digit frequencies than student b's
		 * phone number.
		 */
		public int compare(Student a, Student b) {
			return a.getDigit() - b.getDigit();
		}
	}
}


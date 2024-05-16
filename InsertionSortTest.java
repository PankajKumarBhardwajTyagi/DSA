import java.util.Arrays;

public class InsertionSortTest {
	public static void main(String[] args) {
		char[] data = {'b', 'c', 'd', 'a'}; // [a, b, c, d]
		System.out.println("Initial Data: " + Arrays.toString(data));
		int length = data.length; // 4
		//        1         2        4         3
		for(int index = 1; index < length; ++index) { // begin with the second character
			//     a
			char current = data[index]; // character to insert 
			//      3
			int compareIndex = index; // find the correct index  for character to insert
			//       0           0          -1                   a
			while(compareIndex > 0 && data[compareIndex - 1] > current) { // data[correct index] must go after character to insert
				//      1                b
				data[compareIndex] = data[compareIndex - 1]; // shift characters to right
				--compareIndex; // 0
			}
			//    0               a
			data[compareIndex] = current; // place the character in the proper position
		}
		System.out.println("Sorted Data: " + Arrays.toString(data));
	}
}
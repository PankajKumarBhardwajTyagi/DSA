import java.util.Arrays;

public class CloningTest {
	public static void main(String[] args) {
		int[][] original = {
				{1},
				{2, 3},
				{4, 5, 6}
		};
		
		System.out.println("Original Array: " + Arrays.deepToString(original));
		
		int[][] clonedArray = deepClone(original);
		
		System.out.println("Cloned Array: " + Arrays.deepToString(clonedArray));
	}
	
	private static int[][] deepClone(int[][] original) {
		int[][] backup = new int[original.length][];
		for(int index = 0; index < original.length; ++index)  backup[index] = original[index].clone(); // clone the entire row
		return backup;
	}
}
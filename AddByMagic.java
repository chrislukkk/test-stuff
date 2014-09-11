public class AddByMagic {

	//add two numbers
	public static int add(int a, int b) {
		if (b == 0)
			return a;
		int bitAdd = a ^ b;
		int bitCarry = (a & b) << 1;
		return add(bitAdd, bitCarry);
	}

	//subtract two numbers, a > b
	public static int subtract(int a, int b) {
		return add(a, add(~b, 1));
	}

	public static int multiply (int a, int b) {
		//if a < 0, flip the sign of a and b
		if (a < 0) {
			a = add(~a, 1);
			b = add(~b, 1);
		}
			
		int res = 0;
		while (a > 0) {
			//if there is 1 bit in a, add b
			if ((a & 1) == 1)
				res = add(res, b);
			b <<= 1;
			a >>= 1;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("testing addition:");
		System.out.println("0 + 1 = " + add(0, 1));
		System.out.println("2 + 2 = " + add(2, 2));
		System.out.println("5 + 8 = " + add(5, 8));
		System.out.println("-3 + 4 = " + add(-3, 4));
		System.out.println("-15 + 4 = " + add(-15, 4));
		System.out.println();

		System.out.println("testing subtraction:");
		System.out.println("3 - 1 = " + subtract(3, 1));
		System.out.println("2 - 2 = " + subtract(2, 2));
		System.out.println("5 - 8 = " + subtract(5, 8));
		System.out.println("-3 - (-4) = " + subtract(-3, -4));
		System.out.println("-15 - 4 = " + subtract(-15, 4));
		System.out.println("7 - (-2) = " + subtract(7, -2));
		System.out.println();

		System.out.println("testing multiplication:");
		System.out.println("3 * 7 = " + multiply(3, 7));
		System.out.println("3 * -3 = " + multiply(3, -3));
		System.out.println("-3 * 7 = " + multiply(-3, 7));
	}
}
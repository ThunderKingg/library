package test;

public class Test {
	public void inverse(int[][] arry) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3;j++) {
				System.out.print(arry[j][i]);
			}
			System.out.println();
		}
	}
	public static void table(int num) {
		if (!(num<1 || num > 9)) {
			for(int i = 1; i <= 9; i++) {
				for(int j = 1; j <= i && j != num+1; j++){
					System.out.print(j + "*" + i + "=" + j*i + "\t");
				}
				System.out.println();
			}
		} else {
			System.out.println("输入数字1-9");
		}
	}
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Test {

	private final long THE_ONE_NUMBER = 1;
	private long number;
	private Scanner s = new Scanner(System.in);
	private BigInteger sum = new BigInteger("0");
	private BigInteger unknownNumber;
	private File file = new File("test.txt");
	private int intMaxValue;

	// �������� ��������� �����
	public Long getRandom() {
		return (long) ((Math.random() * number) + THE_ONE_NUMBER);
	}

	// ���������� ����� � ���� �������� 1 ��������� �����
	public void writeToFile() {
		long randomNumber = getRandom();
		try {
			FileWriter fw = new FileWriter(file);
			for (long i = THE_ONE_NUMBER; i <= number; i++) {
				//if (i != randomNumber)
					fw.write(i + "\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//���������� ������������� �������� ����� n, ��� ������� ����� ��������� ���� �� 1 �� n ����� �� ������ Integer Max Value
	public int getNumber () {
		long b = (8L * Integer.MAX_VALUE);
		b = (((long)Math.sqrt((1+b)))-1)/2;
		intMaxValue = (int) ((b*(b + 1))/2);
		return intMaxValue;
	}
	
	//���������� ���� ����� �� 1 �� n �� ������� �����
	public long getNumberForFile (long size) {
		int b = 9;	
		int a = 2;
		int e = 1;
		int f = a * e;
		int d = b * f;
		int c = 6669074;
		int count = 0;
		int itog = 0;

        while (d < c) {
        	int sum = b * e;
        	itog = itog + sum;
        	e *= 10;
        	c = c - d;
        	a++;
        	f = a * e;
        	count = count + d;
        	System.out.println(count);
        	d = b * f;
        }
        itog = itog + (c / a);
        return itog;
	}

	// ��������� ����� �� ����� FileReader �� ����������� ��� �� �� ������ �����
	// ������ � ���������� ���� �� ���������� � �����
	public void readInFile() {
		String readNumber;

		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			
			while ((readNumber = br.readLine()) != null) {
				sum = sum.add(new BigInteger(readNumber));
			}
			br.close();
			isr.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ���������� ����� ���� ����� ���������� �����
	public BigInteger getSumNumber(long a) {
		BigInteger b = new BigInteger(Long.toString(a));
		b = b.multiply(b.add(new BigInteger(Long.toString(THE_ONE_NUMBER))));
		b = b.divide(new BigInteger("2"));
		return b;
	}

	public void work() {

		System.out.println("Please input the number, max value = Long.MAX_VALUE");
		number = s.nextLong();
		writeToFile();
		readInFile();
		s.close();

		System.out.println("The sum of all the numbers entered number - " + getSumNumber(number));
		unknownNumber = getSumNumber(number).subtract(sum); // ���������� �����
															// ������� ��
															// ��������� � ����
		System.out.println("The number is not recorded in the file - " + unknownNumber);
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.work();
	}

}

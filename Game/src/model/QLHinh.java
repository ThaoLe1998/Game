package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class QLHinh {

	private static final String DIR = "hinh/";

	private ArrayList<Icon> hinh;

	public QLHinh() {
		hinh = new ArrayList<Icon>();
		taiDSHinh("icons.txt");

	}

	private void taiDSHinh(String ten) {

		ten = DIR + ten;

		try {
			InputStream str = getClass().getResourceAsStream(ten);
			BufferedReader br = new BufferedReader(new InputStreamReader(str));
			String line;

			while ((line = br.readLine()) != null) {
				if (line.trim().length() == 0) {
					continue;
				}
				taiHinh(line);
			}
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}

	private void taiHinh(String line) {

		line = DIR + line;
		ImageIcon icon = new ImageIcon(getClass().getResource(line));
		if (icon == null)
			return;
		hinh.add(icon);

	}

	public ArrayList<Icon> chonHinh(int index) {
		if (index < 1) {
			return null;
		}

		Random r = new Random();
		int[] list = new int[index];
		Arrays.fill(list, -1);
		ArrayList<Icon> result = new ArrayList<Icon>();

		for (int i = 0; i < index; i++) {
			int in = r.nextInt(index);
			while (ktSo(in, list)) {
				in = (in + 1) % index;
			}
			list[i] = in;
			result.add(hinh.get(in));
		}
		return result;
	}

	private boolean ktSo(int in, int[] list) {
		int leng = list.length;
		for (int i = 0; i < leng; i++) {
			if (in == list[i])
				return true;
		}
		return false;
	}

}

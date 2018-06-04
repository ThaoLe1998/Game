package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.Icon;

import view.Game;
import view.GameMemory;

public class ManHinh extends ManHinhAnh {

	private static final int DIEM = 100;
	private static final int MAX_ICON1 = 6;
	private static final int MAX_ICON2 = 8;
	private static final int MAX_ICON3 = 10;

	public ManHinh() {
		System.out.println(GameMemory.getMap());
		if (GameMemory.getMap() == 1) {
			mhAnh = chonNgauNhien(MAX_ICON1);
		}
		if (GameMemory.getMap() == 2) {
			mhAnh = chonNgauNhien(MAX_ICON2);
		}
		if (GameMemory.getMap() == 3) {
			mhAnh = chonNgauNhien(MAX_ICON3);
		} else {
			
		}
	}

	private Object[] chonNgauNhien(int max) {

		int max2 = max * 2;

		Hinh[] result = new Hinh[max2];

		Hinh[] traVe = hinhDu(max);
		if (traVe == null)
			return null;
		int[] in = new int[max2];
		Arrays.fill(in, -1);
		Random rd = new Random();

		for (int i = 0; i < max2; i++) {
			int index = rd.nextInt(max2);
			while (in[index] == 0)
				index = (index + 1) % max2;
			in[index]++;
			result[index] = traVe[i];
		}

		return result;
	}

	private Hinh[] hinhDu(int max) {

		Hinh[] result = new Hinh[max * 2];
		ArrayList<Icon> list = taoList(max);
		if (list == null) {
			return null;
		}

		for (int i = 0; i < max * 2; i++) {
			result[i] = new Hinh(i % max, DIEM, list.get(i % max));
		}

		return result;
	}

	private ArrayList<Icon> taoList(int max) {

		return new QLHinh().chonHinh(max);
	}

}

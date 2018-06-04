package model;

import java.applet.AudioClip;
import java.util.ArrayList;

import observer.ObserverHinhAnh;
import observer.ObserverXL;

public class Model implements IModel {
	private ArrayList<ObserverHinhAnh> listObsHA;
	private ArrayList<ObserverXL> listObsXL;

	private ManHinhAnh mh = null;
	private Object[] oMH = null;
	private boolean[] flags = null;

	public static final int NONEINDEX = -1;

	private int count = 0;

	public Model() {
		listObsHA = new ArrayList<ObserverHinhAnh>();
		listObsXL = new ArrayList<ObserverXL>();

		mh = new ManHinh();

		oMH = mh.getMhAnh();
		flags = new boolean[oMH.length];

		count = oMH.length;
	}

	
	public void start() {
		notifyObserversHinhAnh();
	}

	
	public void exit() {
		notifyObserversHinhAnh();
		
	}

	
	public void endGame() {
		mh = null;
		notifyObserversHinhAnh();

	}

	
	public void process(int index) {
		int truoc = timChiSoTruoc();

		if (truoc == -1) {
			flags[index] = true;
			notifyObserversXL(NONEINDEX, index, true);
			return;
		}

		if (index == truoc) {
			return;
		}
		boolean b = oMH[truoc].equals(oMH[index]);
		if (b) {
			count = count - 2;

			notifyObserversXL(truoc, index, true);
			if (count == 0) {
				endGame();
			}
			flags[truoc] = false;
		} else {

			flags[truoc] = false;
			flags[index] = true;
			notifyObserversXL(truoc, index, false);
		}

	}

	private int timChiSoTruoc() {

		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				return i;
		}
		return -1;
	}

	
	public void setManHinhAnh(ManHinhAnh display) {
		mh = display;
		if (mh != null) {
			oMH = mh.getMhAnh();
			flags = new boolean[oMH.length];
			return;
		}
		flags = null;
	}

	
	public void notifyObserversHinhAnh() {
		int i = 0;
		while (i < listObsHA.size()) {
			listObsHA.get(i).update(mh);
			i++;
		}

	}

	
	public void registerObserversHinhAnh(ObserverHinhAnh obHA) {
		listObsHA.add(obHA);

	}

	
	public void removeObserversHinhAnh(ObserverHinhAnh obHA) {
		listObsHA.remove(obHA);

	}

	
	public void registerObserversXL(ObserverXL obXL) {
		listObsXL.add(obXL);

	}

	
	public void removeObserversXL(ObserverXL obXL) {
		listObsXL.remove(obXL);

	}

	
	public void notifyObserversXL(int truoc, int hienTai, boolean b) {
		int i = 0;
		while (i < listObsXL.size()) {

			listObsXL.get(i).update(truoc, hienTai, b);
			i++;
		}

	}

}

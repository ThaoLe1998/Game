package model;

import javax.swing.Icon;

public class Hinh {

	private int maID;
	private int diem;
	private Icon hinhAnh;

	public Hinh(int maID, int diem, Icon hinhAnh) {
		super();
		this.maID = maID;
		this.diem = diem;
		this.hinhAnh = hinhAnh;
	}

	public int getMaID() {
		return maID;
	}

	public void setMaID(int maID) {
		this.maID = maID;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public Icon getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(Icon hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public boolean equals(Object that) {
		if (that == null || !(that instanceof Hinh))
			return false;
		else {
			return this.maID == ((Hinh) that).getMaID();
		}
	}

}

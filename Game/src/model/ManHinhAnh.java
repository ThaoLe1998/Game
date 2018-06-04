package model;

public abstract class ManHinhAnh {

	protected Object[] mhAnh;

	protected ManHinhAnh() {
		this.mhAnh = null;
	}

	public Object[] getMhAnh() {
		return mhAnh;
	}

	public void setMhAnh(Object[] mh) {
		this.mhAnh = mh;
	}

}

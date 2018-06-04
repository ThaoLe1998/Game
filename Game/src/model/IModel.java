package model;

import observer.ObserverHinhAnh;
import observer.ObserverXL;

public interface IModel {

	public void start();

	public void exit();

	public void endGame();

	public void process(int index);

	public void setManHinhAnh(ManHinhAnh display);

	public void notifyObserversHinhAnh();

	public void registerObserversHinhAnh(ObserverHinhAnh obHA);

	public void removeObserversHinhAnh(ObserverHinhAnh  obHA);

	public void registerObserversXL(ObserverXL obXL);

	public void removeObserversXL(ObserverXL obXL);

	public void notifyObserversXL(int truoc, int hienTai, boolean b);

}

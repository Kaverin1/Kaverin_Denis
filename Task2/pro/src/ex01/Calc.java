package ex01;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Содержит реализацию методов для вычисления и отображения результатов.
 * 
 * @author xone
 * @version 1.0
 */
public class Calc {
	private static double min = 10.0;  // Set To Your Desired Min Value
	private static double max = 100.0; // Set To Your Desired Max Value
	
	/** Имя файла, используемое при сериализации. */
	private static final String FNAME = "Item2d.bin";
	/** Сохраняет результат вычислений. Объект класса {@linkplain Item2d} */
	private Item2d roomDimensions;

	/** Инициализирует {@linkplain Calc#result} */
	public Calc() {
		roomDimensions = new Item2d();
	}

	/**
	 * Установить значение {@linkplain Calc#result}
	 * 
	 * @param result - новое значение ссылки на объект {@linkplain Item2d}
	 */
	public void setRoomDimensions(Item2d roomDimensions) {

		this.roomDimensions = roomDimensions;
	}

	/**
	 * Получить значение {@linkplain Calc#result}
	 * 
	 * @return текущее значение ссылки на объект {@linkplain Item2d}
	 */
	public Item2d getRoomDimensions() {
		return roomDimensions;
	}
	
	//area, perimeter, volume

	/**
	 * Вычисляет значение функции.
	 * 
	 * @param x - аргумент вычисляемой функции.
	 * @return результат вычисления функции.
	 */
	public double calcArea() {
		return roomDimensions.getWidth() * roomDimensions.getLength();
	}
	
	public double calcPerimeter() {
		return roomDimensions.getWidth()*2 + roomDimensions.getLength()*2;
	}
	
	public double calcVolume() {
		return roomDimensions.getWidth() * roomDimensions.getLength() * roomDimensions.getHeight();
	}

	/**
	 * сохраняет результат в объекте
	 * {@linkplain Calc#result}
	 * 
	 * @param x - аргумент вычисляемой функции.
	 */
	public void init(double width, double length, double height) {
		roomDimensions.setWidth(width);
		roomDimensions.setLength(length);
		roomDimensions.setHeight(height);
	}

	/** Выводит результат вычислений. */
	public void show() {
		System.out.println(roomDimensions);
		System.out.println("Area = " + calcArea() + ", Perimeter = " + calcPerimeter()+ ", Volume = " + calcVolume());
	}
	
	public double generateNumber() {
		double number = Math.random() * (max - min + 1) + min;
		return  (double)Math.round(number * 100) / 100;
	}

	/**
	 * Сохраняет {@linkplain Calc#roomDimensions} в файле {@linkplain Calc#FNAME}
	 * 
	 * @throws IOException
	 */
	public void save() throws IOException {
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
		os.writeObject(roomDimensions);
		os.flush();
		os.close();
	}

	/**
	 * Восстанавливает {@linkplain Calc#roomDimensions} из файла {@linkplain Calc#FNAME}
	 * 
	 * @throws Exception
	 */
	public void restore() throws Exception {
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
		roomDimensions = (Item2d) is.readObject();
		is.close();
	}
}
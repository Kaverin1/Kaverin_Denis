package ex01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import ex01.Item2d;

/**
 * ConcreteProduct (Шаблон проектирования Factory Method)<br>
 * Вычисление функции, сохранение и отображение результатов
 * 
 * @author xone
 * @version 1.0
 * @see View
 */
public class ViewResult implements View {
	private static double min = 10.0;  // Set To Your Desired Min Value
	private static double max = 100.0; // Set To Your Desired Max Value
	/** Имя файла, используемое при сериализации */
	private static final String FNAME = "items.bin";
	/** Определяет количество значений для вычисления по умолчанию */
	private static final int DEFAULT_NUM = 10;
	/** Коллекция аргументов и результатов вычислений */
	private ArrayList<Item2d> items = new ArrayList<Item2d>();

	/**
	 * Вызывает {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)} с
	 * параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
	 */
	public ViewResult() {
		this(DEFAULT_NUM);
	}

	/**
	 * Инициализирует коллекцию {@linkplain ViewResult#items}
	 * 
	 * @param n начальное количество элементов
	 */
	public ViewResult(int n) {
		for (int ctr = 0; ctr < n; ctr++) {
			items.add(new Item2d());
		}
	}

	/**
	 * Получить значение {@linkplain ViewResult#items}
	 * 
	 * @return текущее значение ссылки на объект {@linkplain ArrayList}
	 */
	public ArrayList<Item2d> getItems() {
		return items;
	}
	
	public double calcArea(Item2d item) {
		return item.getWidth() * item.getLength();
	}
	
	public double calcPerimeter(Item2d item) {
		return item.getWidth()*2 + item.getLength()*2;
	}
	
	public double calcVolume(Item2d item) {
		return item.getWidth() * item.getLength() * item.getHeight();
	}
	
	/**
	 * Вычисляет значение функции и сохраняет результат в коллекции
	 * {@linkplain ViewResult#items}
	 * 
	 * @param stepX шаг приращения аргумента
	 */
	public void init() {
		for (Item2d item : items) {
			item.setWLH(generateNumber(), generateNumber(), generateNumber());
		}		
	}
	
	public double generateNumber() {
		double number = Math.random() * (max - min + 1) + min;
		return  (double)Math.round(number * 100) / 100;
	}

	/**
	 * Вызывает <b>init(double stepX)</b> со случайным значением аргумента<br>
	 * * {@inheritDoc}
	 */
	@Override
	public void viewInit() {
		init();
	}

	/**
	 * Реализация метода {@linkplain View#viewSave()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewSave() throws IOException {
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
		os.writeObject(items);
		os.flush();
		os.close();
	}

	/**
	 * Реализация метода {@linkplain View#viewRestore()}<br>
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void viewRestore() throws Exception {
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
		items = (ArrayList<Item2d>) is.readObject();
		is.close();
	}

	/**
	 * Реализация метода {@linkplain View#viewHeader()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewHeader() {
		System.out.println("Results:");
	}

	/**
	 * Реализация метода {@linkplain View#viewBody()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewBody() {
		for (Item2d item : items) {
			System.out.printf("(w:%.3f; l:%.3f; h:%.3f; a:%.3f; p:%.3f; v:%.3f;)%n", item.getWidth(), item.getLength(), item.getHeight(), calcArea(item), calcPerimeter(item), calcVolume(item));
		}
		System.out.println();
	}

	/**
	 * Реализация метода {@linkplain View#viewFooter()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewFooter() {
		System.out.println("End.");
	}

	/**
	 * Реализация метода {@linkplain View#viewShow()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewShow() {
		viewHeader();
		viewBody();
		viewFooter();
	}
}

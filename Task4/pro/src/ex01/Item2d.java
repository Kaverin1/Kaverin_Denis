package ex01;

import java.io.Serializable;

/**
 * Хранит исходные данные и результат вычислений.
 * 
 * @author xone
 * @version 1.0
 */
public class Item2d implements Serializable {	
	/** Аргумент вычисляемой функции. */
// transient
	private double width;
	/** Результат вычисления функции. */
	private double height;	
	/** Результат вычисления функции. */
	private double length;

	/** Автоматически сгенерированная константа */
	private static final long serialVersionUID = 1L;

	/** Инициализирует поля {@linkplain Item2d#width}, {@linkplain Item2d#height}, {@linkplain Item2d#length} */
	public Item2d() {
		width = .0;
		height = .0;
		length = .0;
	}

	/**
	 * Устанавливает значения полей: аргумента и результата вычисления функции.
	 * 
	 * @param width - значение для инициализации поля {@linkplain Item2d#width}
	 * @param height - значение для инициализации поля {@linkplain Item2d#height}
	 * @param length - значение для инициализации поля {@linkplain Item2d#length}
	 */
	public Item2d(double width, double length, double height) {
		this.width = width;
		this.length = length;
		this.height = height;
	}

	/**
	 * Установка значения поля {@linkplain Item2d#width}
	 * 
	 * @param x - значение для {@linkplain Item2d#width}
	 * @return Значение {@linkplain Item2d#width}
	 */
	public double setWidth(double width) {
		return this.width = width;
	}

	/**
	 * Получение значения поля {@linkplain Item2d#width}
	 * 
	 * @return Значение {@linkplain Item2d#width}
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Установка значения поля {@linkplain Item2d#length}
	 * 
	 * @param y - значение для {@linkplain Item2d#length}
	 * @return Значение {@linkplain Item2d#length}
	 */
	public double setLength(double length) {
		return this.length = length;
	}

	/**
	 * Получение значения поля {@linkplain Item2d#length}
	 * 
	 * @return значение {@linkplain Item2d#length}
	 */
	public double getLength() {
		return length;
	}
	
	/**
	 * Установка значения поля {@linkplain Item2d#height}
	 * 
	 * @param y - значение для {@linkplain Item2d#height}
	 * @return Значение {@linkplain Item2d#height}
	 */
	public double setHeight(double height) {
		return this.height = height;
	}

	/**
	 * Получение значения поля {@linkplain Item2d#height}
	 * 
	 * @return значение {@linkplain Item2d#height}
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Установка значений {@linkplain Item2d#width}, {@linkplain Item2d#length} и {@linkplain Item2d#height}
	 * 
	 * @param x - значение для {@linkplain Item2d#width}
	 * @param y - значение для {@linkplain Item2d#length}
	 * @param y - значение для {@linkplain Item2d#height}
	 * @return this
	 */
	public Item2d setWLH(double width, double length, double height) {
		this.width = width;
		this.length = length;
		this.height = height;
		return this;
	}

	/**
	 * Представляет результат вычислений в виде строки.<br>
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "width = " + width + ", length = " + length+ ", height = " + height;
	}

	@Override
	public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Item2d other = (Item2d) obj;
        
        return this.width == other.width && this.length == other.length &&
        		this.height == other.height;
    }
}
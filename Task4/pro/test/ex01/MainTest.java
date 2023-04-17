package ex01;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import java.io.IOException;

/**
 * Выполняет тестирование разработанных классов.
 * 
 * @author xone
 * @version 1.0
 */
public class MainTest {
	/** Проверка основной функциональности класса {@linkplain ViewResult} */
	@Test
	public void testCalc() {
		ViewResult view = new ViewResult(1);
		view.init();
		
		Item2d item = view.getItems().get(0);
		item.setWLH(1, 2, 3);
		assertEquals(1.0, item.getWidth(), 0);
		assertEquals(2.0, item.getLength(), 0);
		assertEquals(3.0, item.getHeight(), 0);
		assertEquals(2.0, view.calcArea(item), 0);
		assertEquals(6.0, view.calcPerimeter(item), 0);
		assertEquals(6.0, view.calcVolume(item), 0);

	}

	/** Проверка сериализации. Корректность восстановления данных. */
	@Test
	public void testRestore() {
		ViewResult view1 = new ViewResult(1000);
		ViewResult view2 = new ViewResult();
		// Вычислим значение функции со случайным шагом приращения аргумента
		view1.init();
		// Сохраним коллекцию view1.items
		try {
			view1.viewSave();
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		// Загрузим коллекцию view2.items
		try {
			view2.viewRestore();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		// Должны загрузить столько же элементов, сколько сохранили
		assertEquals(view1.getItems().size(), view2.getItems().size());
		// Причем эти элементы должны быть равны.
		// Для этого нужно определить метод equals
		assertTrue("containsAll()", view1.getItems().containsAll(view2.getItems()));
	}

}
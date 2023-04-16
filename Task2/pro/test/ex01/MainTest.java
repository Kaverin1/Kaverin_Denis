package ex01;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.Assert;
import java.io.IOException;
import ex01.Calc;

/**
 * Выполняет тестирование разработанных классов.
 * 
 * @author xone
 * @version 1.0
 */
public class MainTest {
	/** Проверка основной функциональности класса {@linkplain Calc} */
	@Test
	public void testCalc() {
		Calc calc = new Calc();
		calc.init(1, 2, 3);
		assertEquals(1.0, calc.getRoomDimensions().getWidth(),0);
		assertEquals(2.0, calc.getRoomDimensions().getLength(),0);
		assertEquals(3.0, calc.getRoomDimensions().getHeight(),0);
		assertEquals(2.0, calc.calcArea(),0);
		assertEquals(6.0, calc.calcPerimeter(),0);
		assertEquals(6.0, calc.calcVolume(),0);

	}

	/** Проверка сериализации. Корректность восстановления данных. */
	@Test
	public void testRestore() {
		Calc calc = new Calc();
		double width, length, height;
		for (int ctr = 0; ctr < 1000; ctr++) {
			width = calc.generateNumber();
			length = calc.generateNumber();
			height = calc.generateNumber();
			calc.init(width, length, height);
			try {
				calc.save();
			} catch (IOException e) {
				Assert.fail(e.getMessage());
			}
			calc.init(calc.generateNumber(), calc.generateNumber(), calc.generateNumber());
			try {
				calc.restore();
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
			assertEquals(width, calc.getRoomDimensions().getWidth(), .1e-10);
			assertEquals(length, calc.getRoomDimensions().getLength(), .1e-10);
			assertEquals(height, calc.getRoomDimensions().getHeight(), .1e-10);
		}
	}
}
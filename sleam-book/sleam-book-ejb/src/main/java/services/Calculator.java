package services;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Calculator
 */
@Stateless
public class Calculator implements CalculatorRemote, CalculatorLocal {

	/**
	 * Default constructor.
	 */
	public Calculator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer add(Integer a, Integer b) {
		return a + b;
	}

}

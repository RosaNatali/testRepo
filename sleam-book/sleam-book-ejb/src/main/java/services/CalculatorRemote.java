package services;

import javax.ejb.Remote;

@Remote
public interface CalculatorRemote {
	Integer add(Integer a, Integer b);

}

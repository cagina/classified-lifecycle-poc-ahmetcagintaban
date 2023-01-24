package sahininden.com.classified.lifecycle.poc.constants;

import java.util.HashSet;

public class ConstantsSingleton {
	public HashSet<String> words = new HashSet<>();
	private static ConstantsSingleton instance = null;
	public ConstantsSingleton() {}
	public static ConstantsSingleton getInstance()
	{
		if (instance == null)
			instance = new ConstantsSingleton();
		return instance;
	}
}

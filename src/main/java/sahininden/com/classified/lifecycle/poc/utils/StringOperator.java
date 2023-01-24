package sahininden.com.classified.lifecycle.poc.utils;

import org.springframework.stereotype.Component;
import sahininden.com.classified.lifecycle.poc.constants.ConstantsSingleton;
import sahininden.com.classified.lifecycle.poc.enums.IlanCategory;

@Component
public class StringOperator {
	public boolean containWords(String[] splitStrings) {
		boolean exist = false;
		for (String splitString : splitStrings) {
			if (ConstantsSingleton.getInstance().words.contains(splitString)) {
				exist = true;
				break;
			}
		}
		return exist;
	}

	public IlanCategory findByIlanCategoryEnumValue(String value) {
		IlanCategory result = null;
		for (IlanCategory category : IlanCategory.values()) {
			if (category.name().equals(value)) {
				result = category;
				break;
			}
		}
		return result;
	}
}

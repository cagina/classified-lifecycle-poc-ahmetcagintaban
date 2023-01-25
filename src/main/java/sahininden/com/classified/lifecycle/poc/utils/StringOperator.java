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

	public boolean firstCharIsValid(String str) {
		// ASCII
		// 65 - 90 A B C .... Z
		// 97 - 122 a b c ..... z
		// 48 - 57 0 1 2 3 .... 9
		// Ğ - ğ 286 287
		// Ü - ü 220 252
		// Ş - ş 350 351
		// İ 304
		// Ö - ö 214 246
		// Ç - ç 199 231
		if (	((int)str.charAt(0) >= 65 &&  (int)str.charAt(0) <= 90)  ||
				((int)str.charAt(0) >= 97 &&  (int)str.charAt(0) <= 122) ||
				((int)str.charAt(0) >= 48 &&  (int)str.charAt(0) <= 57))
			return true;

		switch ((int)str.charAt(0)) {
			case 286:
			case 287:
			case 220:
			case 252:
			case 350:
			case 351:
			case 304:
			case 214:
			case 246:
			case 199:
			case 231:
				return true;
			default:
				return false;
		}
	}
}

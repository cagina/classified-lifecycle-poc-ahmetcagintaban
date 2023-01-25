package sahininden.com.classified.lifecycle.poc.constants;

import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class BadWordsToHashSet {
	@PostConstruct
	public void constantsSetup() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("words/Badwords.txt");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				ConstantsSingleton.getInstance().words.add(line);
			}
		}
		System.out.println("ConstantsSetup Completed...");
	}
}

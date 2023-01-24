package sahininden.com.classified.lifecycle.poc.constants;

import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import java.io.*;

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

package ua.logos.service.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class CustomFileUtils {

	private String PROJECT_PATH = System.getProperty("user.fir");
	private String SEPARATOR = System.getProperty("file.separator");

	private String ROOT_PATH = PROJECT_PATH + SEPARATOR + "upload";
	
	public void saveUploadedFile(MultipartFile file) throws IOException {

		if (file.isEmpty()) {
			return;
		}
		
		createFolder();
		
		byte[] bytes = file.getBytes();
		Path path = Paths.get(ROOT_PATH + SEPARATOR + file.getOriginalFilename());
		Files.write(path, bytes);

	}
	
	private void createFolder() throws IOException {
		
		Path directory = Paths.get(ROOT_PATH);
		if(!Files.exists(directory)) {
			Files.createDirectories(directory);
		}
	}
}

package com.johnkuper.epam.dependson;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("fileCreatorImpl")
public class FileHandlerImpl implements FileHandler {

	@Override
	@Value("${file.location")
	public void printFileInfo(String fileLocation) {
		File file = new File(fileLocation);
		System.out.println(file.length());
	}

}

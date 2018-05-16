package main.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;

import org.springframework.stereotype.Component;

import main.exceptions.ExceptionMessage;
import main.exceptions.GameStoreIOException;

@Component
public class CDKeyReaderImpl implements CDKeyReader {
	private final static String directory = "src\\main\\resources\\CDKeys";

	@Override
	public File getCDKeyFile(Long fileNumber) throws GameStoreIOException {
		File file = new File(directory);
		File cdkeyFile;
		File[] matchingFiles = file.listFiles(new FilenameFilter() {
			public boolean accept(File directory, String name) {
				return name.endsWith(fileNumber.toString());
			}
		});
		if (matchingFiles.length != 1) {
			throw new GameStoreIOException(ExceptionMessage.NOTFOUND, "CD Key");
		} else {
			cdkeyFile = matchingFiles[0];
		}
		try (BufferedReader reader = new BufferedReader(new FileReader(cdkeyFile))) {

			String cdkey = reader.readLine();
			System.out.println(cdkey);
			return cdkeyFile;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

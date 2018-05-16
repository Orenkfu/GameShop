package main.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import org.springframework.stereotype.Component;

import main.exceptions.ExceptionMessage;
import main.exceptions.GameStoreIOException;

@Component
public class CDKeyWriterImpl implements CDKeyWriter {
	private final static String directory = "src\\main\\resources\\CDKeys\\";
	private Random rnd;

	public CDKeyWriterImpl() {
		rnd = new Random();
	}

	@Override
	public Long WriteCDKey(String cdkey, String productName) throws GameStoreIOException {
		Long rng = new Long(rnd.nextLong());
		try (PrintWriter writer = new PrintWriter(new File(directory + productName + rng.toString()))) {
			writer.write(cdkey);
			return rng;
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new GameStoreIOException(ExceptionMessage.CDKEYWRITER);
	}

}

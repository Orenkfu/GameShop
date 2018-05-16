package main;

import main.exceptions.GameStoreIOException;
import main.io.CDKeyReaderImpl;
import main.io.CDKeyWriterImpl;

public class Test {
	public static void main(String[] args) throws GameStoreIOException {
		CDKeyWriterImpl writer = new CDKeyWriterImpl();
		writer.WriteCDKey("123401242134122BdEQ32O", "Bioshock");
		CDKeyReaderImpl reader = new CDKeyReaderImpl();
		reader.getCDKeyFile(6368823396784136167L);
	}
}

package main.io;

import java.io.File;

import main.exceptions.GameStoreIOException;

public interface CDKeyReader {
	public File getCDKeyFile(Long fileNumber) throws GameStoreIOException;
}

package main.io;

import main.exceptions.GameStoreIOException;

public interface CDKeyWriter {

	public Long WriteCDKey(String cdkey, String productName) throws GameStoreIOException;
}

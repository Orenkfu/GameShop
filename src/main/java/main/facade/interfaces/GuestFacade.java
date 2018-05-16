package main.facade.interfaces;

import main.beans.ClientType;
import main.beans.entities.GeneralClient;
import main.exceptions.GameStoreException;

/**
 * @author Yura Kourlyand
 */
public interface GuestFacade extends GeneralClientFacade {
	GeneralClient signup(GeneralClient generalClient, ClientType type) throws GameStoreException;

	GeneralClientFacade login(String name, String password, ClientType type) throws GameStoreException;

}

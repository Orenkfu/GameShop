package main.resources.interfaces;

import main.beans.entities.GeneralClient;
import main.exceptions.GameStoreException;
import main.facade.interfaces.GeneralClientFacade;

public interface GuestResource extends GeneralClientResource {
	GeneralClient vendorSignup(GeneralClient generalClient) throws GameStoreException;

	GeneralClient userSignup(GeneralClient generalClient) throws GameStoreException;

	GeneralClientFacade vendorLogin(String name, String password) throws GameStoreException;

	GeneralClientFacade userLogin(String name, String password) throws GameStoreException;

}

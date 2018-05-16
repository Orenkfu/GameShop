package main.exceptions;

public enum ExceptionMessage {
	GENERALERROR, BADLOGINCLIENTTYPE, HIGHDISCOUNT, LOWDISCOUNT, GENERALEMPTYFIELD, GAMENOTFOUNDUPDATE, VENDORNOTFOUNDUPDATE, USERNOTFOUNDUPDATE, GAMEEXISTS, VENDOREXISTS, USEREXISTS, SCREENSHOTSFULL, RETAILIMAGESFULL, BADLOGIN, BADEMAIL, EMPTYFIELDSIGNUP, BADPASSWORD, NOTFOUND, EXISTS, CDKEYWRITER, MAILFAILURE, MAILNOTSENT, NOTLOGGEDIN;

	public static final String IMAGE = "Image";
	public static final String VENDOR = "Vendor";
	public static final String GAME = "Game";
	public static final String USER = "User";
	public static final String SCREENSHOT = "Screenshot";
	public static final String GALLERY = "Gallery";

	public String getValue(String name) {
		switch (this) {
		case NOTFOUND:
			return name + " not found.";
		case EXISTS:
			return name + " already exists.";
		case MAILNOTSENT:
			return "Could not send " + name + " email.";
		default:
			return "Request failed. an error has occurred.";
		}

	}

	public String getValue() {
		switch (this) {
		case BADPASSWORD:
			return "Password must only use contain atLeast  1 num, 1Big latter, 1 Small latter, between 8 and 16 chars";
		case EMPTYFIELDSIGNUP:
			return "Please fill all the sign-up fields except date and id";
		case BADEMAIL:
			return "Please enter a valid email address";
		case GENERALERROR:
			return "Request failed. an error has occurred.";
		case BADLOGINCLIENTTYPE:
			return "Wrong client type.";
		case BADLOGIN:
			return "Wrong username or password";
		case HIGHDISCOUNT:
			return "Cannot set discount above 100%.";
		case LOWDISCOUNT:
			return "Cannot set discount below 0%.";
		case GENERALEMPTYFIELD:
			return "Please fill all mandatory fields.";
		case GAMENOTFOUNDUPDATE:
			return "Cannot update game, does not exist in database.";
		case VENDORNOTFOUNDUPDATE:
			return "Cannot update vendor, does not exist in database.";
		case USERNOTFOUNDUPDATE:
			return "Cannot update user, does not exist in database.";
		case GAMEEXISTS:
			return "Cannot save game, already has an ID.";
		case USEREXISTS:
			return "Cannot save user, already has an ID.";
		case VENDOREXISTS:
			return "Cannot save vendor, already has an ID.";
		case SCREENSHOTSFULL:
			return "Failed to add screenshot. Maximum screenshots allowed: 5.";
		case RETAILIMAGESFULL:
			return "Failed to add image. Maximum images allowed: 5.";
		case CDKEYWRITER:
			return "Failed to write CDKey to file.";
		case MAILFAILURE:
			return "Failed to send email.";
		case MAILNOTSENT:
			return "Could not send email.";
		case NOTLOGGEDIN:
			return "You are not logged in.";
		default:
			return "Request failed. an error has occurred.";

		}
	}

}

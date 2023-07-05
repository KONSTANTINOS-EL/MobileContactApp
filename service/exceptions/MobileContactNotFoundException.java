package service.exceptions;

import model.MobileContact;

public class MobileContactNotFoundException extends Exception{
    private final static long serialVersionUID = 1L;

    public MobileContactNotFoundException(String phoneNumber) {
        super("the mobile contact with phone number" + phoneNumber + "was not found");

    }

    public MobileContactNotFoundException(MobileContact mobileContact) {
        super("the mobile contact with phone number" + mobileContact.getPhoneNumber() + "was not found");

    }

    public MobileContactNotFoundException(long id) {
        super("the mobile contact with id" + id + "was not found");
    }
}

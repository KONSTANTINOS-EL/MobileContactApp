package service.exceptions;

import model.MobileContact;

public class UserAlreadyExistsException extends  Exception{
    private final static long serialVersionUID = 1L;

    public UserAlreadyExistsException(MobileContact mobileContact) {
        super("Mobile contact with id" + mobileContact.getId() + "already exists");
    }
}

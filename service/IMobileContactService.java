package service;

import dto.MobileContactDTO;
import model.MobileContact;
import service.exceptions.MobileContactNotFoundException;
import service.exceptions.PhoneNumberAlreadyExistsException;
import service.exceptions.UserAlreadyExistsException;

import java.util.List;

public interface IMobileContactService {
    MobileContact insertMobileContact(MobileContactDTO contactDTO) throws PhoneNumberAlreadyExistsException, UserAlreadyExistsException;

    /**
     *
     * @param contactDTO
     * @return
     * @throws PhoneNumberAlreadyExistsException
     * @throws UserAlreadyExistsException
     */

    MobileContact updateMobileContact(long id, MobileContactDTO contactDTO)
            throws MobileContactNotFoundException, UserAlreadyExistsException, PhoneNumberAlreadyExistsException;

    /**
     *
     * @param phoneNumber
     * @throws MobileContactNotFoundException
     */
    void deleteMobileContact(String phoneNumber) throws MobileContactNotFoundException;

    /**
     *
     * @param id
     * @throws MobileContactNotFoundException
     */
    void deleteMobileContact(long id) throws MobileContactNotFoundException;

    /**
     *
     * @param phoneNumber
     * @return
     * @throws MobileContactNotFoundException
     */
    MobileContact getMobileContact(String phoneNumber) throws MobileContactNotFoundException;

    /**
     *
     * @param id
     * @return
     * @throws MobileContactNotFoundException
     */
    MobileContact getMobileContact(long id) throws MobileContactNotFoundException;

    /**
     *
     * @return
     */
    List<MobileContact> getAllMobileContacts();
    /**
     *
     */
}

package service;

import dao.IMobileContactDao;
import dto.MobileContactDTO;
import dto.UserDetailsDTO;
import model.MobileContact;
import model.UserDetails;
import service.exceptions.MobileContactNotFoundException;
import service.exceptions.PhoneNumberAlreadyExistsException;
import service.exceptions.UserAlreadyExistsException;

import java.util.List;

public class MobileContactsServiceImpl implements IMobileContactService{
    private final IMobileContactDao dao;

    public MobileContactsServiceImpl(IMobileContactDao dao) {
        this.dao = dao;
    }

    @Override
    public MobileContact insertMobileContact(MobileContactDTO contactDTO) throws PhoneNumberAlreadyExistsException, UserAlreadyExistsException {
        MobileContact mobileContact;
        try {
            mobileContact = new MobileContact();
            if (dao.phoneNumberExist(contactDTO.getPhoneNumber())) {
                throw new PhoneNumberAlreadyExistsException(mobileContact);
            }
            if (dao.userIdExist(contactDTO.getId())) {
                throw new UserAlreadyExistsException(mobileContact);
            }

            mapMobileContact(mobileContact, contactDTO);

            mobileContact = dao.insert(mobileContact);



        }catch (PhoneNumberAlreadyExistsException | UserAlreadyExistsException e) {
            e.printStackTrace();
            throw e;
        }
        return mobileContact;
    }


    @Override
    public MobileContact updateMobileContact(long id, MobileContactDTO contactDTO) throws MobileContactNotFoundException, UserAlreadyExistsException, PhoneNumberAlreadyExistsException {
        MobileContact mobileContact;
        try {
            mobileContact = new MobileContact();
            if (id != contactDTO.getId() || !dao.userIdExist(id)) {
                throw new MobileContactNotFoundException(id);
            }
            if (dao.phoneNumberExist(contactDTO.getPhoneNumber())) {
                throw new PhoneNumberAlreadyExistsException(mobileContact);
            }

            if (dao.phoneNumberExist(contactDTO.getPhoneNumber())) {
                if ((!dao.get(contactDTO.getId()).equals(dao.get(contactDTO.getPhoneNumber()))));
            }

//            if (dao.userIdExist(contactDTO.getId())) {
//                throw new UserAlreadyExistsException(mobileContact);
//            }


            mapMobileContact(mobileContact, contactDTO);
            mobileContact = dao.update(id, mobileContact);




        }catch (PhoneNumberAlreadyExistsException e) {
            e.printStackTrace();
            throw e;
        }
        return mobileContact;
    }

    @Override
    public void deleteMobileContact(String phoneNumber) throws MobileContactNotFoundException {
        MobileContact mobileContact;
        try {
            mobileContact = new MobileContact();
            if (!dao.phoneNumberExist(phoneNumber)) {
                throw new MobileContactNotFoundException(mobileContact);
            }
            dao.delete(phoneNumber);
        } catch (MobileContactNotFoundException e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public void deleteMobileContact(long id) throws MobileContactNotFoundException {
        MobileContact mobileContact;
        try {
            mobileContact = new MobileContact();
            if (!dao.userIdExist(id)) {
                throw new MobileContactNotFoundException(mobileContact);
            }
            dao.delete(id);
        } catch (MobileContactNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public MobileContact getMobileContact(String phoneNumber) throws MobileContactNotFoundException {
       MobileContact mobileContact;
       try {
           mobileContact = dao.get(phoneNumber);
           if (mobileContact == null) {
               throw new MobileContactNotFoundException(phoneNumber);
           }

       } catch (MobileContactNotFoundException e) {
           e.printStackTrace();
           throw e;
       }
        return mobileContact;
    }

    @Override
    public MobileContact getMobileContact(long id) throws MobileContactNotFoundException {
        MobileContact mobileContact;
        try {
            mobileContact = dao.get(id);
            if (mobileContact == null) {
                throw new MobileContactNotFoundException(id);
            }

        } catch (MobileContactNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        return mobileContact;
    }

    @Override
    public List<MobileContact> getAllMobileContacts() {
        return null;
    }
    private void mapMobileContact(MobileContact mobileContact, MobileContactDTO mobileContactDTO) {
        mobileContact.setId(mobileContactDTO.getId());
        mobileContact.setPhoneNumber(mobileContactDTO.getPhoneNumber());
        UserDetails userDetails = new UserDetails();
        mapUserDetails(userDetails, mobileContactDTO.getUserDetails());
        mobileContact.setUserDetails(userDetails);

    }

    private void mapUserDetails(UserDetails userDetails, UserDetailsDTO userDetailsDTO) {
        userDetails.setId(userDetailsDTO.getId());
        userDetails.setFirstname(userDetailsDTO.getFirstname());
        userDetails.setLastname(userDetailsDTO.getLastname());
    }

}

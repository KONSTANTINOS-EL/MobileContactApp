package service;

import dao.IMobileContactDao;
import dao.MobileContactDAOImpl;
import dto.MobileContactDTO;
import dto.UserDetailsDTO;
import model.MobileContact;
import service.exceptions.MobileContactNotFoundException;
import service.exceptions.PhoneNumberAlreadyExistsException;
import service.exceptions.UserAlreadyExistsException;

import java.util.List;

public class MobileContactApp {
    private static final IMobileContactDao dao = new MobileContactDAOImpl();
    private static final IMobileContactService service = new MobileContactsServiceImpl(dao);


    public static void main(String[] args) {
        try {
            //DTO
            UserDetailsDTO userDetailsDTO = new UserDetailsDTO(1L, "Alice", "W.");
            MobileContactDTO mobileContactDTO = new MobileContactDTO(1L, userDetailsDTO, "123445666");

            UserDetailsDTO updatedUserDetailsDTO = new UserDetailsDTO(1L, "Alice", "Wonderland");
            MobileContactDTO updateMobileContactDTO = new MobileContactDTO(1L, userDetailsDTO, "123243556");

            //Service
            service.insertMobileContact(mobileContactDTO);
            service.updateMobileContact(1L, updateMobileContactDTO);

            //Return back
            List<MobileContact> contacts = service.getAllMobileContacts();
            for (MobileContact contact : contacts) {
                System.out.println(contact);
            }


        } catch (PhoneNumberAlreadyExistsException | UserAlreadyExistsException | MobileContactNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

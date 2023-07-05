package dao;

import model.MobileContact;

import java.util.List;


public interface IMobileContactDao {

    /**
     * Insert an new{@link MobileContact} instance in the datasource
     *
     * @param mobileContact
     *              the model object contains the mobile contact data.
     * @return the resulting {@link MobileContact}
     */

    MobileContact insert(MobileContact mobileContact);

    /**
     * Update {@link MobileContact}
     *
     * @param id
     * @param mobileContact
     *          the object that contains the mobile contact data.
     * @return the resulting {@link MobileContact}
     *
     */
    MobileContact update(long id, MobileContact mobileContact);

    /**
     * Remove a {@link  MobileContact} from the datasource.
     *
     * @param phoneNumber
     *              the phoneNumber of the {@link  MobileContact} needed to
     *              be removed.
     */
    void delete(String phoneNumber);

    /**
     * Returns a {@link MobileContact} based on the input id.
     *
     * @param id
     *          the  to be returned.
     * @return the resulting {@link MobileContact}
     */
    MobileContact get(long id);

    /**
     * Rerunrns all the {@link MobileContact} instances from the data source.
     *
     * @return the resulting {@link List<MobileContact>}
     */
    List<MobileContact> getAll();

    /**
     * Returns a {@link MobileContact} instance from the data source
     * based on the input phone number.
     *
     * @param phoneNumber
     *              the
     *              to be returned.
     *
     * @return the resulting {@link MobileContact}
     */
    MobileContact get(String phoneNumber);

    /**
     * Remove a {@link  MobileContact} from the datasource.
     *
     * @param id
     *          the id of the {@link  MobileContact} needed to
     *          be removed.
     */
    void delete(long id);

    /**
     * Checks if the phone numbers already exists in the datasource
     * as a part of{@link MobileContact}
     *
     * @param phoneNumber
     *                  thr <code>phone number</code> to be searched.
     *
     * @return
     *          the <code>phone number</code> exists in a
     *          {@link MobileContact} in datasource.
     */
    boolean phoneNumberExist(String phoneNumber);

    /**
     *  Checks if an id already exists in the datasource
     *  as a part of {@link MobileContact}
     *
     * @param id
     *          the id to be searched
     * @return
     *         true if the <code>id</code> exists as a part of
     *         a {@link MobileContact} in datasource.
     */
    boolean userIdExist(long id);
}

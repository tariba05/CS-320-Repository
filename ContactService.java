/*
 * Mod 3 Assignment
 * CS 320
 * 
 * 7/20/25
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String newFirstName) {
        contacts.get(contactId).setFirstName(newFirstName);
    }

    public void updateLastName(String contactId, String newLastName) {
        contacts.get(contactId).setLastName(newLastName);
    }

    public void updatePhone(String contactId, String newPhone) {
        contacts.get(contactId).setPhone(newPhone);
    }

    public void updateAddress(String contactId, String newAddress) {
        contacts.get(contactId).setAddress(newAddress);
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}

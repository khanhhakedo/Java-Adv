package com.vti.frontend;

import com.vti.entity.AddressOneToOne;
import com.vti.entity.UserOneToOne;
import com.vti.repository.Addressrepository;
import com.vti.repository.UserRepository;

public class ProgramOneToOne {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        Addressrepository addressRepository = new Addressrepository();
//
//        AddressOneToOne address = new AddressOneToOne();
//        address.setCity("ha noi");
//        address.setStreet("cau giay");
//        addressRepository.createAddress(address);
//
//        AddressOneToOne address1 = addressRepository.getAddressByID(2);
//        UserOneToOne user = new UserOneToOne();
//        user.setUserName("khanh2");
//        user.setAddress(address1);
//        userRepository.createUser(user);

//        System.out.println(addressRepository.getAddressByID(1));
//        System.out.println(addressRepository.getAddressByStreet("pham hung"));
//        addressRepository.getAllAddress();
//        userRepository.getAllUsers();
        addressRepository.getAddressByID(3);
//        addressRepository.getAllAndUserAddress();
    }




}


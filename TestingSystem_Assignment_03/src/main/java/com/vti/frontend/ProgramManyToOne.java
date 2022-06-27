package com.vti.frontend;

import com.vti.entity.AddressManyToOne;
import com.vti.entity.UserManyToOne;
import com.vti.repository.Addressrepository;
import com.vti.repository.UserRepository;

public class ProgramManyToOne {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        Addressrepository addressRepository = new Addressrepository();

//        AddressManyToOne address = new AddressManyToOne();
//        address.setCity("ha noi");
//        address.setStreet("cau giay");
//        addressRepository.createAddressManyToOne(address);
//
//        AddressManyToOne address1 = addressRepository.getAddressByIDManyToOne(1);
//        UserManyToOne user = new UserManyToOne();
//        user.setUserName("khanh1");
//        user.setAddressManyToOne(address1);
//        userRepository.createUserManyToOne(user);


//        userRepository.getAllUsersManyToOne();
//        addressRepository.getAddressAndUserByID(1);
        addressRepository.getAllAndUserAddressManyToOne();
    }
}

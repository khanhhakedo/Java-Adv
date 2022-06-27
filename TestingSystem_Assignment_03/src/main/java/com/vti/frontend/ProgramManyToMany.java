package com.vti.frontend;

import com.vti.entity.AddressManyToMany;
import com.vti.entity.UserManyToMany;
import com.vti.repository.Addressrepository;
import com.vti.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class ProgramManyToMany {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        Addressrepository addressRepository = new Addressrepository();

//        AddressManyToMany address = new AddressManyToMany();
//        address.setCity("ha noi");
//        address.setStreet("ho tung mau");
//        addressRepository.createAddressManyToMany(address);
//
//        AddressManyToMany address1 = addressRepository.getAddressByIDManyToMany(2);
//        UserManyToMany user = new UserManyToMany();
//        user.setUserName("khanh1");
//        userRepository.createUserManyToMany(user);

        userRepository.getAllUsersManyToMany();



    }


}

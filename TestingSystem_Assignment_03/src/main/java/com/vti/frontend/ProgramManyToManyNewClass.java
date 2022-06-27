package com.vti.frontend;


import com.vti.entity.Address;
import com.vti.entity.User;
import com.vti.entity.UserAddress;
import com.vti.repository.Addressrepository;
import com.vti.repository.UserAddressrepository;
import com.vti.repository.UserRepository;

public class ProgramManyToManyNewClass {
    public static void main(String[] args) {
        Addressrepository addressRepository = new Addressrepository();
        UserRepository userRepository = new UserRepository();
        UserAddressrepository userAddressrepository = new UserAddressrepository();

//        Address address =new Address();
//        address.setStreet("Pham Hung");
//        address.setCity("ha noi");
//        addressRepository.createAddress(address);
//
//        Address address2 =new Address();
//        address2.setStreet("thanh Pho");
//        address2.setCity("Thai Binh");
//        addressRepository.createAddress(address2);
//
//        User user = new User();
//        user.setUsername("khanh");
//        userRepository.createUser1(user);

//        Address address2 = addressRepository.getAddresByID(1);
//        User user2 = userRepository.getUserByID(1);
//
//
//        UserAddress userAddress = new UserAddress();
//        userAddress.setAddress(address2);
//        userAddress.setUser(user2);
//userAddressrepository.createUserAddress(userAddress);
userAddressrepository.getAll();





    }
}

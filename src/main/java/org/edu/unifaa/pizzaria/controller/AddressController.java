package org.edu.unifaa.pizzaria.controller;

import org.edu.unifaa.pizzaria.model.Address;
import org.edu.unifaa.pizzaria.model.Customer;
import org.edu.unifaa.pizzaria.service.AddressService;
import org.edu.unifaa.pizzaria.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    // Injetando o CustomerService para buscar o cliente associado ao endereço
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Optional<Address> address = addressService.getAddressById(id);
        if (address.isPresent()) {
            return new ResponseEntity<>(address.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Método corrigido para criar o endereço e vincular ao customerId
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address, @RequestParam Long customerId) {
        // Aqui está a correção. O customerId precisa ser passado como segundo argumento para saveAddress
        Address createdAddress = addressService.saveAddress(address, customerId);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }
    
    

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address updatedAddress) {
        Optional<Address> address = addressService.updateAddress(id, updatedAddress);
        if (address.isPresent()) {
            return new ResponseEntity<>(address.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        if (addressService.deleteAddress(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

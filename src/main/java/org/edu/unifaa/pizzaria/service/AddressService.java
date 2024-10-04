
package org.edu.unifaa.pizzaria.service;

import org.edu.unifaa.pizzaria.model.Address;
import org.edu.unifaa.pizzaria.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.edu.unifaa.pizzaria.repository.CustomerRepository;
import org.edu.unifaa.pizzaria.model.Customer;


import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    // Novo método para salvar o endereço associando-o ao cliente
    public Address saveAddress(Address address, Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            address.setCustomer(customer.get());  // Associa o cliente ao endereço
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
        return addressRepository.save(address);
    }

    public Optional<Address> updateAddress(Long id, Address updatedAddress) {
        return addressRepository.findById(id).map(address -> {
            address.setCep(updatedAddress.getCep());
            address.setRua(updatedAddress.getRua());
            address.setNumero(updatedAddress.getNumero());
            address.setBairro(updatedAddress.getBairro());
            address.setComplemento(updatedAddress.getComplemento());
            address.setCidade(updatedAddress.getCidade());
            address.setEstado(updatedAddress.getEstado());
            address.setCustomer(updatedAddress.getCustomer());  // Mantém ou atualiza a associação com o cliente
            return addressRepository.save(address);
        });
    }

    public boolean deleteAddress(Long id) {
        return addressRepository.findById(id).map(address -> {
            addressRepository.delete(address);
            return true;
        }).orElse(false);
    }
}
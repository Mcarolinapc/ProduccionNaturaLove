package com.NaturaLove.ProductNaturaLove.Services;

import com.NaturaLove.ProductNaturaLove.Model.Customer;
import com.NaturaLove.ProductNaturaLove.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Iterable <Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(String id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            return customerRepository.save(customer);
        } else {
            throw new IllegalArgumentException("Customer with id " + id + " does not exist.");
        }
    }
}

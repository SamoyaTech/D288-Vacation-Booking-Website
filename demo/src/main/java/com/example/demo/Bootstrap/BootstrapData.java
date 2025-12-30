package com.example.demo.Bootstrap;

import com.example.demo.dao.CountryRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Country;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;
    private final CountryRepository countryRepository;

    public BootstrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository,  CountryRepository countryRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //only run sample data if there is 0 or 1 customer
        if (customerRepository.count() <= 1) {
       //load an existing country
            Country country = countryRepository.findById(1L)
                    .orElseThrow(() -> new RuntimeException("Country not found"));
            //create a division
            Division division = new Division();
            division.setDivision_name("Division 1");
            division.setCountry(country);
            divisionRepository.save(division);

            //create 5 sample customers
            Customer c1 = new Customer("Sammy", "Wilkins",
                    "100 Main St", "58101", "2223333", division);
            Customer c2 = new Customer("Joe", "Williams",
                    "101 Main St", "58102", "2223334", division);
            Customer c3 = new Customer("Jake", "Barnett",
                    "111 County Rd", "58103", "2223335", division);
            Customer c4 = new Customer("Alana", "Brown",
                    "212 Moon Crescent", "58104", "2223336", division);
            Customer c5 = new Customer("Benny", "Benson",
                    "51 6th Ave  ", "58101", "2223337", division);

            customerRepository.save(c1);
            customerRepository.save(c2);
            customerRepository.save(c3);
            customerRepository.save(c4);
            customerRepository.save(c5);

            System.out.println("Loaded sample customers: " + customerRepository.count());


        }
    }
}

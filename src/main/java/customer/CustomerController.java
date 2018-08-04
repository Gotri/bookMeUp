package customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(path = "/")
    public String index() {
        return "Hello, this is the Web-Service to manage Customers";
    }

    @GetMapping(path = "/add")
    public @ResponseBody
    String addNewCustomer(@RequestParam String firstName, @RequestParam String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customerRepository.save(customer);
        return "You successfully added a new Customer";
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody
    Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/getByLastName")
    public @ResponseBody
    List<Customer> getByLastName(@RequestParam String lastName) {
        return customerRepository.findByLastName(lastName);
    }
}

package bookmeup.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(path = "/view")
    public String customerView(Model model) {
        model.addAttribute("customers", getAllCustomers());
        return "customer";
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

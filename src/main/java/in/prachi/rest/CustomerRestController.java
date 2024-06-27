package in.prachi.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.prachi.entity.Customer;

@RestController
public class CustomerRestController {
	@GetMapping("/customer")
	public ResponseEntity<Customer>getCustomer(){
		//get it from database
		Customer c = new Customer(1,"John","john@gmail.com");
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
  @GetMapping(value="/list",produces="application/json")
    public List<Customer> getCustomers(){
	//logic to get record from db
    	Customer c1 = new Customer(1,"John","john@gmail.com");
    	Customer c2 = new Customer(2,"Johniya","johniya@gmail.com");
    	Customer c3 = new Customer(3,"Johnwa","johnwa@gmail.com");
    	Customer c4 = new Customer(4,"JohnCina","johncina@gmail.com");
       List<Customer> customers = Arrays.asList(c1,c2,c3,c4);
       return customers;
    }
   @PostMapping(value="/customer",produces="application/json")
   public ResponseEntity <String >addCustomer(@RequestBody Customer c) {
	System.out.println(c);
	//TODO: DB logic to insert the record
	String body= "Customer Added";
	return new ResponseEntity<>(body,HttpStatus.CREATED);
}
   @PutMapping(value="/customer",produces="string/text",consumes="application/json")
   //db logic to update the record
   public String updateCustomer(@RequestBody Customer c) {
	   System.out.println(c);
	   return "Customer updated";
   }
    @DeleteMapping(value="/customer/{cid}",produces= "text/plain")
    public String deleteCustomer(@PathVariable Integer cid) {
    	//db logic to delete
		return "customer deleted";
	}
    
}

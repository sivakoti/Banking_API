
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.DeleteMapping

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(private val customerService:CustomerService){

    @GetMapping
    fun getAllCustomers():ResponseEntity<List<Customer>> {
        val customers = customerService.getAllCustomers()
        return ResponseEntity.status(HttpStatus.OK).body(customers)
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id:Long): ResponseEntity<Customer?> {
        val customer = customerService.getCustomerById(id);
        return if(customer!=null){
            ResponseEntity.status(HttpStatus.OK).body(customer)
        }
        else{
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping
    fun addCustomer(@RequestBody customer:Customer):ResponseEntity<Customer>{
        val newCustomer= customerService.addCustomer(customer)
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer)
    }

    @PostMapping("/{id}")
    fun updateCustomerById(@PathVariable id:Long,@RequestBody updateCustomer:Customer):ResponseEntity<Customer>{
        val updatedCustomer = customerService.updateCustomerById(id, updateCustomer)
        return if(updatedCustomer!=null){
            ResponseEntity.status(HttpStatus.OK).body(updatedCustomer)
        }
        else{
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
        fun deleteCustomerById(@PathVariable id:Long):ResponseEntity<Unit>{
            val deleteCustomer = customerService.deleteCustomerById(id)
            return ResponseEntity.status(HttpStatus.OK).body(deleteCustomer)
        }
}

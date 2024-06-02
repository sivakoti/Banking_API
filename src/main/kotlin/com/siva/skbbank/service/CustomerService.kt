import org.springframework.stereotype.Service

interface CustomerService{
    fun getAllCustomers():List<Customer>
    fun getCustomerById(id:Long):Customer?
    fun addCustomer(customer:Customer):Customer
    fun updateCustomerById(id:Long,updatedCustomer:Customer):Customer?
    fun deleteCustomerById(id:Long)
}

@Service
class CustomerServiceImpl(private val customerRepository:CustomerRepository):CustomerService{

    override fun getAllCustomers(): List<Customer> = customerRepository.findAll()

    override fun getCustomerById(id: Long): Customer? = customerRepository.findById(id).orElse(null)

    override fun addCustomer(customer: Customer): Customer = customerRepository.save(customer)

    override fun updateCustomerById(id: Long, updatedCustomer: Customer): Customer? {
        return if(customerRepository.existsById(id)){
            customerRepository.save(updatedCustomer)
        }
        else{
            null
        }
    }
    override fun deleteCustomerById(id: Long) = customerRepository.deleteById(id)
}
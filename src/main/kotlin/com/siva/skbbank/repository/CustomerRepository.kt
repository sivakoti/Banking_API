import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface CustomerRepository:JpaRepository<Customer,Long>
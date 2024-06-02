import jakarta.persistence.Table
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import java.time.LocalDate

@Entity
@Table(name = "customer")
data class Customer(
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    val id:Long,
    var name:String,
    var email:String,
    var phone:String,
    @Embedded
    var address:Address?,
    var updatetime:LocalDate?
)

@Embeddable
data class Address(
    var street:String,
    var pincode:Int,
    var city:String,
    var country:String
)
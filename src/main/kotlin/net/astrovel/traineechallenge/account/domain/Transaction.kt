package net.astrovel.traineechallenge.account.domain
import jakarta.persistence.*

@Entity
@Table(name = "transactions")
class Transaction  {

    @Id
    var id: Long = 1L
    var description: String = "null"
    var amount: Int = 0
    var operationType: OperationType? = OperationType.DEPOSITO
    @JoinColumn(name = "account_id", referencedColumnName = "id",foreignKey = ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(fetch = FetchType.LAZY)
    var account: Account? = null

    //fun getAccount(): Account? {return this.account}

//    fun setAccount(value: Account) {
//        account = value
//    }

    constructor(_id: Long,_description: String,_amount: Int, _operationType: OperationType){
        this.id = _id
        this.description = _description
        this.amount = _amount
        this.operationType = _operationType
    }

    constructor(d: String,a: Int,opType: OperationType){
        description = d
        amount = a
        operationType = opType
    }

}

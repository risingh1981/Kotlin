class BankAccount() {
    var open = true
    var balance: Long = 0
        get() {if (open) { return field } else {throw IllegalStateException("Account is closed")}}


    fun adjustBalance(amount: Long){
        if (open) {
            updateBalance(amount)
        }
        else {
            throw IllegalStateException("A closed accounts balance cannot be adjusted")
        }
    }

    @Synchronized private fun updateBalance(amount: Long){
        balance += amount
    }

    fun close() {
        if (open) {
            open = false
            balance = 0
        } else {
            throw IllegalStateException("A closed account cannot be closed")
        }
    }
}
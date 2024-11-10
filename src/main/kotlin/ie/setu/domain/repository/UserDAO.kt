package ie.setu.domain.repository
import ie.setu.utils.mapToUser
import ie.setu.domain.User
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.selectAll
import ie.setu.domain.db.Users

class UserDAO {

   /* private val users = arrayListOf<User>(
        User(name = "Alice", email = "alice@wonderland.com", id = 0),
        User(name = "Bob", email = "bob@cat.ie", id = 1),
        User(name = "Mary", email = "mary@contrary.com", id = 2),
        User(name = "Carol", email = "carol@singer.com", id = 3)

    )
    */

    fun getAll(): ArrayList<User> {
        val userList: ArrayList<User> = arrayListOf()
        transaction {
            Users.selectAll().map {
                userList.add(mapToUser(it)) }
        }
        return userList
    }


    /*
    fun save(user: User){
        users.add(user)
    }

    fun findById(id: Int): User?{
        return users.find {it.id == id}
    }


    fun findByEmail(email: String) :User?{
        return users.find { it.email == email }
    }

    fun delete(id: Int) {
        val user = findById(id)
        users.remove(user)
    }

    fun update(id: Int, user: User){
        val foundUser = findById(id)
        foundUser?.email = user.email
        foundUser?.name = user.name
        foundUser?.id = user.id
    }

*/










}


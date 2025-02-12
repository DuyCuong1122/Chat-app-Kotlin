import com.google.firebase.Timestamp

data class User(
    val id: String? = null,
    val name: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val dateOfBirth: Timestamp? = null,
    val createdAt: Timestamp? = null,
    val updatedAt: Timestamp? = null,
    val listFriends: List<String>? = null,
    val fcmtoken: String? = null
)

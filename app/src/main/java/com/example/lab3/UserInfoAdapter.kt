import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.R
import com.example.lab3.UserInfo

class UserInfoAdapter(private val userList: List<UserInfo>) :
    RecyclerView.Adapter<UserInfoAdapter.UserInfoViewHolder>() {

    class UserInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtEmail: TextView = itemView.findViewById(R.id.txtEmail)
        val txtPhone: TextView = itemView.findViewById(R.id.txtPhone)
        val txtGender: TextView = itemView.findViewById(R.id.txtGender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user_info, parent, false)
        return UserInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserInfoViewHolder, position: Int) {
        val userInfo = userList[position]
        holder.txtName.text = userInfo.name
        holder.txtEmail.text = userInfo.email
        holder.txtPhone.text = userInfo.phone
        holder.txtGender.text = userInfo.gender
    }

    override fun getItemCount() = userList.size
}

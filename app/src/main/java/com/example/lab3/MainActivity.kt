package com.example.lab3

import UserInfoAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userInfoAdapter: UserInfoAdapter
    private val userInfoList = mutableListOf<UserInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtName: EditText = findViewById(R.id.edtName)
        val edtEmail: EditText = findViewById(R.id.edtEmail)
        val edtPhone: EditText = findViewById(R.id.edtPhone)
        val radioGroupGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val checkboxTerms: CheckBox = findViewById(R.id.checkboxTerms)
        val btnSave: Button = findViewById(R.id.btnSave)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        userInfoAdapter = UserInfoAdapter(userInfoList)
        recyclerView.adapter = userInfoAdapter

        btnSave.setOnClickListener {
            val name = edtName.text.toString()
            val email = edtEmail.text.toString()
            val phone = edtPhone.text.toString()
            val selectedGenderId = radioGroupGender.checkedRadioButtonId
            val gender = when (selectedGenderId) {
                R.id.radioMale -> "Nam"
                R.id.radioFemale -> "Nữ"
                R.id.radioOther -> "Khác"
                else -> ""
            }

            if (checkboxTerms.isChecked) {
                val userInfo = UserInfo(name, email, phone, gender)
                userInfoList.add(userInfo)
                userInfoAdapter.notifyDataSetChanged()
                clearFields(edtName, edtEmail, edtPhone, radioGroupGender, checkboxTerms)
            } else {
                Toast.makeText(this, "Bạn phải đồng ý với điều khoản sử dụng", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearFields(
        edtName: EditText,
        edtEmail: EditText,
        edtPhone: EditText,
        radioGroup: RadioGroup,
        checkbox: CheckBox
    ) {
        edtName.text.clear()
        edtEmail.text.clear()
        edtPhone.text.clear()
        radioGroup.clearCheck()
        checkbox.isChecked = false
    }
}

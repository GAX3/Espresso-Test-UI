package com.example.espresso_test_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.espresso_test_ui.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setUpView()
    }

    private fun setUpView() {
        mBinding.btnLogin.setOnClickListener(View.OnClickListener() {
            mBinding.tvErrorLogin.visibility = View.GONE
            var username = mBinding.edtLoginUsername.text.toString()
            var password = mBinding.edtLoginPassword.text.toString()

            if (username != null && username.length < 4){
                mBinding.tvErrorLogin.setText(R.string.login_username_error)
                mBinding.tvErrorLogin.visibility= View.VISIBLE
                return@OnClickListener
            }
            if (username != null && password.length < 4){
                mBinding.tvErrorLogin.setText(R.string.login_password_error)
                mBinding.tvErrorLogin.visibility= View.VISIBLE
                return@OnClickListener
            }
            doLoginBackEnd(username, password)
        })
    }

    private fun doLoginBackEnd(username: String, password: String) {
        if (username == "Alberto" && password == "123456"){
            var intent = Intent(applicationContext, RecyclerActivity::class.java)
            intent.putExtra("USER", username)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Username $username incorrecto", Toast.LENGTH_SHORT).show()
        }
    }
}
    package equipo.dos.proyecto_equipo2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var etEmail: EditText = findViewById(R.id.etEmail)
        var etPassword: EditText = findViewById(R.id.etPassword)
        var cbRemember: CheckBox = findViewById(R.id.checkRemember)
        var btnLogin: Button = findViewById(R.id.btnLogIn)
        var tvSignUp: TextView = findViewById(R.id.linkSignUp)

        var email: String = etEmail.text.toString()
        var password: String = etPassword.text.toString()



        btnLogin.setOnClickListener {

            if(validarCredenciales(email, password)){
                var intent = Intent(this, HomeActivity::class.java)
                this.startActivity(intent)
            }else{
                Toast.makeText(this, "Email o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }

        }

        tvSignUp.setOnClickListener {
            var intent = Intent(this, Register_Activity::class.java)
            this.startActivity(intent)
        }

    }
    fun validarCredenciales(email: String, password: String): Boolean{
        // Pendiente para el backEnd
        return true
    }

}
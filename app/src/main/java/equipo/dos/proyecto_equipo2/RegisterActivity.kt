package equipo.dos.proyecto_equipo2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        var etName: EditText = findViewById(R.id.etNombre)
        var etEmail: EditText = findViewById(R.id.etEmail)
        var etPassword: EditText = findViewById(R.id.etPassword)
        var etPasswordConfirm: EditText = findViewById(R.id.etConfirmPassword)
        var btnCreate: Button = findViewById(R.id.btnCreate)
        var tvLogin: TextView = findViewById(R.id.linkLogIn)

        var email : String = etEmail.text.toString()

        btnCreate.setOnClickListener {
            if(validarEmailRepetido(email)){
                Toast.makeText(this, "Cuenta creada exitósamente", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, MainActivity::class.java)
                this.startActivity(intent)
            }else{
                Toast.makeText(this, "Email actualmente en uso", Toast.LENGTH_SHORT).show()
            }
        }

        tvLogin.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }


    }

    fun validarEmailRepetido(email: String): Boolean{
        // Pendiente para el backend
        return true
    }
}
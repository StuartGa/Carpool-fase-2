package com.example.carpool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

const val USER_NAME ="org.bedu.activity.USER_NAME"

class MainActivity : AppCompatActivity() {

    lateinit var usuario: EditText
    lateinit var contrasena:EditText
    lateinit var inspector:ImageView
    lateinit var button: Button
    lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usuario= findViewById(R.id.EditUsuario)
        contrasena=findViewById(R.id.EditContrasena)
        inspector=findViewById(R.id.inspector)
        button=findViewById(R.id.Login)
        inspector=findViewById(R.id.inspector)
        textView = findViewById(R.id.textView)

        //Iniciamos el listener

        button.setOnClickListener {
            if (usuario.text.isEmpty()||contrasena.text.isEmpty()){
                textView.setText(R.string.Errorlogin)
                //textView.setTextColor(R.color.)
                inspector.setImageResource(R.drawable.wrong)
                contrasena.error="Contraseña incorrecta"
            }else{

                textView.setText(R.string.OKlogin)
                inspector.setImageResource(R.drawable.correct)
                val bundle =Bundle()
                bundle.putString(USER_NAME, usuario.text.toString())
                val intent = Intent(this, Welcome::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
                }
        }

    }

}
package com.example.barbearia.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.barbearia.R
import com.example.barbearia.adapter.ServicosAdapter
import com.example.barbearia.databinding.ActivityHomeBinding
import com.example.barbearia.model.Servicos

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicosAdapter: ServicosAdapter
    private val listaServicos: MutableList<Servicos> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val nome = intent.extras?.getString("nome")

        binding.txtNomeUsuario.text = "Bem vindo, $nome"
        val recyclerViewrServicos = binding.recyclerViewServiOs
        recyclerViewrServicos.layoutManager = GridLayoutManager(this, 2)
        servicosAdapter = ServicosAdapter(this,listaServicos)
        recyclerViewrServicos.setHasFixedSize(true)
        recyclerViewrServicos.adapter = servicosAdapter
        getSetvicos()

        binding.btAgendar.setOnClickListener {
            val intent = Intent(this,Agendamento::class.java)
            intent.putExtra("nome",nome)
            startActivity(intent)
        }

    }

    private fun getSetvicos(){

        val servico1 = Servicos(R. drawable.img1, nome = "Corte de cabelo")
        listaServicos.add(servico1)

        val servico2 = Servicos(R. drawable.img2, nome = "Corte de barba")
        listaServicos.add(servico2)

        val servico3 = Servicos(R. drawable.img3, nome = "Lavagem de cabelo")
        listaServicos.add(servico3)

        val servico4 = Servicos(R. drawable.img4, nome = "Tratamento de cabelo")
        listaServicos.add(servico4)

    }

}
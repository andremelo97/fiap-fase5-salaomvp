package br.com.fiap.salaomvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import br.com.fiap.salaomvp.R
import br.com.fiap.salaomvp.adapter.ServicosAdapter
import br.com.fiap.salaomvp.databinding.ActivityHomeBinding
import br.com.fiap.salaomvp.model.Servicos

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

        binding.txtNomeUsuario.text = "Bem-vindo(a), $nome!"
        val recycleViewServicos = binding.recyclerViewServicos
        recycleViewServicos.layoutManager = GridLayoutManager(this, 2)
        servicosAdapter = ServicosAdapter(this, listaServicos)
        recycleViewServicos.setHasFixedSize(true)
        recycleViewServicos.adapter = servicosAdapter
        getServicos()

        binding.btAgendar.setOnClickListener {
            val intent = Intent(this, Agendamento::class.java)
            intent.putExtra("nome", nome)
            startActivity(intent)
        }
    }

    private fun getServicos() {
        val servico1 = Servicos(R.drawable.corte1, "Cabelo")
        listaServicos.add(servico1)

        val servico2 = Servicos(R.drawable.barba1, "Barba")
        listaServicos.add(servico2)

        val servico3 = Servicos(R.drawable.hidra1, "Lavagem e Hidratação")
        listaServicos.add(servico3)

        val servico4 = Servicos(R.drawable.pe_mao1, "Mãos e Pés")
        listaServicos.add(servico4)
    }
}
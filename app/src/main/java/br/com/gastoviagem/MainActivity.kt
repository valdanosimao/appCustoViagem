package br.com.gastoviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /**
     * Função responsável por fazer a criação da Activity
     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //adiciona evento ao elemento da interface
        binding.btnCalculate.setOnClickListener(this)
    }

    /**
     * Função responsável por tratar qualquer evento de click nos elementos
     */
    override fun onClick(view: View) {
        //Obtém o id do elemento clicado
        if (view.id == R.id.btn_calculate) {
            calculate()
        }
    }

    /**
     * Função que Verifica se todos os campos foram preenchidos
     */
    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    /**
     * Função responsável por realizar o cálculo dos gastos com a viagem
     * Baseado na distância percorrida * preço médio do combustível / pela autonomia do veículo
     */
    private fun calculate() {
        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            // realiza o cálculo ((distance * price) / autonomy)
            val totalValue = (distance * price) / autonomy
            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"

        } else{
            // Caso não tenha preenchido todos os campos, solicita o preenchimento
            Toast.makeText(this, R.string.validation_fill_all_fields, Toast.LENGTH_LONG).show()
        }
    }
}
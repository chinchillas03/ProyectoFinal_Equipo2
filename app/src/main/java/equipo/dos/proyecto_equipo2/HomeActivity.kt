package equipo.dos.proyecto_equipo2
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import org.w3c.dom.Text

class HomeActivity : AppCompatActivity() {

    var registers = ArrayList<Register>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        addProducts()

        var listview:ListView = findViewById(R.id.registerListView) as ListView

        var adapter:RegisterAdapter = RegisterAdapter(registers, this)

        listview.adapter = adapter


    }
    fun addProducts(){
        registers.add(Register("Excelent", 24, 39.0f, 80.0f, 13.0f ))
        registers.add(Register("Bad", 24, 39.0f, 80.0f, 13.0f ))

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


    class RegisterAdapter:BaseAdapter{


        var registers = ArrayList<Register>()

        var context: Context? = null

        constructor(registers:ArrayList<Register>, context:Context){
            this.registers=registers
            this.context = context
        }

        override fun getCount(): Int {
            return registers.size
        }

        override fun getItem(position: Int): Any {
            return registers[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var reg =  registers[position]
            var inflator = LayoutInflater.from(context)
            var view = inflator.inflate(R.layout.single_register_item, null)

            var sleepState = view.findViewById(R.id.sleepStateTxt) as TextView
            var sleepHours = view.findViewById(R.id.sleepHoursTxt) as TextView
            var consumedCals = view.findViewById(R.id.consumedCalsTxt) as TextView
            var weight = view.findViewById(R.id.weigthTxt) as TextView
            var realizedExcercise = view.findViewById(R.id.realizedExcerciseTxt) as TextView

            sleepState.setText(reg.sleepState)
            sleepHours.setText(reg.sleepHours.toString())
            consumedCals.setText(reg.consumedCals.toString())
            weight.setText(reg.weight.toString())
            realizedExcercise.setText(reg.realizedExcercise.toString())


            return view

        }


    }
}

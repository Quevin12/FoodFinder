package Ltd.co.foodfinder

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            // food map for different times of the day//

            val foodmap = mapOf(
                "morning" to listOf("1:pancakes with egg and bacon","2:toast with avocado","3:Greek yoghurt","4:fruit and vegetable smoothie"),
                "afternoon" to listOf("1:Chickpea salad sandwich","2:Chicken stir fry","3:Stuffed mushrooms","4:Chicken or beef wrap","5:Deviled eggs"),
                "dinner" to listOf("1:Butter chicken","2:Lasagne","3:Thai beef salad","4:Creamy garlic and prawns","5:Ramen","6:Soup"),
                "after dinner snack" to listOf("1:Turkey and vegetables","2:Protein shake","3:Peanut Butter on whole grain bread","4:Egg and fruit","5:Yoghurt with berries and granola")
            )

            val inputTime = findViewById<EditText>(R.id.inputTime)
            val resultsText = findViewById<TextView>(R.id.resultsText)
            val requestButton = findViewById<Button>(R.id.requestButton)
            val clearButton = findViewById<Button>(R.id.clearButton)

            requestButton.setOnClickListener {
                val time = inputTime.text.toString().lowercase().trim()
                Log.d("DEBUG", "User typed: '$time'")  //log helped with case sensative issues
                val foods = foodmap[time]

                // if and ELSE BLOCK

                if (foods != null) {
                    resultsText.text = foods.joinToString("\n")
                } else {
                    resultsText.text = "No suggestions for \"$time\""
                }
            }

            clearButton.setOnClickListener{
                inputTime.text.clear()
                resultsText.text = "Display results here"
            }

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
     }
    }
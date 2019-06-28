package fr.epita.a2019_apping_resit_mealdb

import android.content.Intent


import android.media.Image
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


/*
class MovieCharacterListAdapter(private val context: Context,private val data: MutableList<Item>) : BaseAdapter() {


    override fun getCount(): Int {
        // returns the number of items in this adapter
        // usually the size of the underlying List/Array...
        return data.size
    }

    override fun getItem(position: Int): Item {
        // returns the data item at the specified position in the list
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        //return the ID of the specified row (customized or row position)
        return position.toLong()
    }

    //the getView() method receives a position and must return the
    // corresponding row view
    override fun getView(position: Int,convertView: View?,parent: ViewGroup?): View {
        // first let us retrieve the item at the specified positionval currentItem: Item = getItem(position)// now we build a view// first step, acquire a LayoutInflaterval layoutInflater = LayoutInflater.from(context)// now use this LayoutInflater to inflate our row layout resource// into a Viewval rowView = layoutInflater.inflate(R.layout.list_item,parent,false);// bind variables to the distinct views inside our row viewval nameTextView = rowView.findViewById<TextView>(R.id.item_txt_name)// finally, time to put the data in herenameTextView.text = currentItem.name// job’s done, the view is built and contains the data for the// requested position, we can return it to the systemreturn rowView;}
    }

}*/


class MainActivity : AppCompatActivity() {

    var categories = arrayListOf<Categories>()
    var meals = arrayListOf<Meals>()

    val base_URL = "https://themealdb.com/api/json/v1/1/categories.php"

    val json_converter = GsonConverterFactory.create(GsonBuilder().create())
    val retrofit_categories = Retrofit.Builder().baseUrl(base_URL).addConverterFactory(json_converter).build()
    //val retrofit_meals = Retrofit.Builder().baseUrl(base_URL).addConverterFactory(json_converter).build()


    val service: WebService = retrofit_categories.create(WebService::class.java)
    //val service: WebServiceInterface = retrofitClient.create(WebServiceInterface::class.java)!!







    val callback = object : Callback<Categories> {

        override fun onFailure(call: Call<Categories>, t: Throwable) {
            Log.d("Connect API", "The Application MealDBapp failed to contact the api")
            Log.d("Connect API", call.request().toString())
        }

        override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
             if (response.code() == 200) {
                val data:Categories = response.body()!!

                //
                val myIntent = Intent(this@MainActivity, MainActivity::class.java)
                myIntent.putExtra("idCategory", data.idCategory)
                myIntent.putExtra("strCategory", data.strCategory)
                myIntent.putExtra("strCategoryThumb",data.strCategoryThumb)
                myIntent.putExtra("strCategoryDescription", data.strCategoryDescription)



                startActivity(myIntent)
            }
            else {
                Log.d("Response code", response.code().toString())
                Log.d("Response Body", response.body().toString())
            }


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val category_selector = intent.getIntExtra("category_selector", -1)
    }

    fun get_category_image(id: Int): Int {
        var category_selector = 0
        /*when(id) {
            1 -> category_selector =
            2 -> category_selector =
            3 -> category_selector =
            4 -> category_selector =
            5 -> category_selector =
            6 -> category_selector =
            7 -> category_selector =
            8 -> category_selector =
            9 -> category_selector =
            10 -> category_selector =
            11 -> category_selector =
        }*/
        return category_selector
    }

    fun get_meal_image(id: Int): Int {
        var meal_selector = 0
        /*when(id) {
            1 -> category_selector =
            2 -> category_selector =
            3 -> category_selector =
            4 -> category_selector =
            5 -> category_selector =
            6 -> category_selector =
            7 -> category_selector =
            8 -> category_selector =
            9 -> category_selector =
            10 -> category_selector =
            11 -> category_selector =
        }*/
        return meal_selector
    }
}

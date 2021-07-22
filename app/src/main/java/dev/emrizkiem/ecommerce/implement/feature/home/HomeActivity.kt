package dev.emrizkiem.ecommerce.implement.feature.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.implement.data.Category
import dev.emrizkiem.ecommerce.implement.data.Product
import dev.emrizkiem.ecommerce.implement.feature.detail.DetailProductActivity
import dev.emrizkiem.ecommerce.implement.feature.login.LoginActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var productAdapter: ProductAdapter
    private lateinit var categoryAdapter: CategoryAdapter

    private lateinit var auth: FirebaseAuth
    private lateinit var dbReference: DatabaseReference
    private lateinit var dbInstance: FirebaseDatabase

    private lateinit var listData: ArrayList<Product>
    private lateinit var listDataCategory: ArrayList<Category>

    private lateinit var rvCategory: RecyclerView
    private lateinit var rvProduct: RecyclerView
    private lateinit var logOut: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvCategory = findViewById(R.id.rv_category)
        rvProduct = findViewById(R.id.rv_product)
        logOut = findViewById(R.id.ic_logout)

        auth = FirebaseAuth.getInstance()
        dbInstance = FirebaseDatabase.getInstance()

//        if (auth.currentUser == null) {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//        } else {
//            Log.d("Check User", "Already logged in")
//        }

        getDataCategoryFromFirebase()
        getDataProductFromFirebase()
        goToLogout()
    }

    private fun getDataCategoryFromFirebase() {
        listDataCategory = ArrayList()
        categoryAdapter = CategoryAdapter(listDataCategory)

        rvCategory.layoutManager = GridLayoutManager(this, 2)
        rvCategory.setHasFixedSize(true)

        dbReference = dbInstance.getReference("category")
        dbReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (data in snapshot.children) {
                        val item = data.getValue(Category::class.java)
                        item?.let { listDataCategory.add(it) }
                    }
                    rvCategory.adapter = categoryAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    private fun getDataProductFromFirebase() {
        listData = ArrayList()
        productAdapter = ProductAdapter(listData) {
            startActivity(Intent(this@HomeActivity, DetailProductActivity::class.java))
        }

        rvProduct.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvProduct.setHasFixedSize(true)

        dbReference = dbInstance.getReference("products")
        dbReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (data in snapshot.children) {
                        val item = data.getValue(Product::class.java)
                        item?.let { listData.add(it) }
                    }
                    rvProduct.adapter = productAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    private fun goToLogout() {
        logOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
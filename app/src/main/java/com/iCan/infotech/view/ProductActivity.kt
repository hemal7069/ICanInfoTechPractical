package com.iCan.infotech.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iCan.infotech.R
import com.iCan.infotech.di.Injection
import com.iCan.infotech.model.product.Product
import com.iCan.infotech.view_model.ProductViewModel

class ProductActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var tvError: AppCompatTextView

    private lateinit var layoutError: LinearLayout
    private lateinit var layoutEmpty: FrameLayout

    private lateinit var rvProductList: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        initViewModel()
        initUI()
    }

    private fun initUI() {
        progressBar = findViewById(R.id.progressBar)
        tvError = findViewById(R.id.tvError)
        layoutError = findViewById(R.id.layoutError)
        layoutEmpty = findViewById(R.id.layoutEmpty)

        rvProductList = findViewById(R.id.rvProductList)
        rvProductList.layoutManager = LinearLayoutManager(this)

        productAdapter = ProductAdapter(viewModel.products.value ?: emptyList())
        rvProductList.adapter = productAdapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            Injection.provideViewModelFactory()
        ).get(ProductViewModel::class.java)

        viewModel.products.observe(this, renderProducts)
        viewModel.isViewLoading.observe(this, isViewLoadingObserver)
        viewModel.onMessageError.observe(this, onMessageErrorObserver)
        viewModel.isEmptyList.observe(this, emptyListObserver)
    }

    private val renderProducts = Observer<List<Product>> {
        Log.v("TAG", "data updated $it")

        layoutError.visibility = View.GONE
        layoutEmpty.visibility = View.GONE

        productAdapter.update(it)
    }

    private val isViewLoadingObserver = Observer<Boolean> {
        Log.v("TAG", "isViewLoading $it")

        val visibility = if (it) View.VISIBLE else View.GONE
        progressBar.visibility = visibility
    }

    @SuppressLint("SetTextI18n")
    private val onMessageErrorObserver = Observer<Any> {
        Log.v("TAG", "onMessageError $it")

        layoutError.visibility = View.VISIBLE
        layoutEmpty.visibility = View.GONE

        tvError.text = "Error $it"
    }

    private val emptyListObserver = Observer<Boolean> {
        Log.v("TAG", "emptyListObserver $it")

        layoutEmpty.visibility = View.VISIBLE
        layoutError.visibility = View.GONE
    }

    override fun onResume() {
        super.onResume()

        viewModel.loadProducts(
            1,
            "qxWOVJ26A6xezTscJKIj",
            7,
            1,
            1,
            1,
            10
        )
    }
}
package com.phillipilino.concatadapterexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ConcatAdapter
import com.phillipilino.basehelpers.adapters.BaseAdapter
import com.phillipilino.basehelpers.adapters.BaseVH
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_item_one.view.*
import kotlinx.android.synthetic.main.layout_item_one.view.txt_info
import kotlinx.android.synthetic.main.layout_item_two.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapterOne = ItemOneAdapter()
        val adapterTwo = ItemTwoAdapter()
        val adapterThree = ItemThreeAdapter()

        val concatAdapter = ConcatAdapter(adapterOne, adapterTwo, adapterThree)
        recycler.adapter = concatAdapter

        var infos = mutableListOf(
            Pair("Nome", "Phillipi"),
            Pair("Sobrenome", "Lino"),
            Pair("Idade", "25"))

        adapterOne.loadItems(listOf("Título"), null)
        adapterTwo.loadItems(infos, null)
        adapterThree.loadItems(listOf("")) { _, _, _ ->
            infos.add(Pair("Teste", "Adicionado com sucesso"))
            adapterTwo.notifyItemInserted(infos.size - 1)
        }
    }
}

class ItemOneAdapter: BaseAdapter<String>() {
    override fun getLayoutId(position: Int, obj: String) = R.layout.layout_item_one
    override fun getViewHolder(view: View, viewType: Int) = ItemOneVH(view)
}

class ItemOneVH(view: View) : BaseVH<String>(view) {
    override fun bind(item: String, position: Int, onItemPressed: ((View, String, Int) -> Unit)?) {
        super.bind(item, position, onItemPressed)
        view.txt_info.text = item
    }
}

class ItemTwoAdapter: BaseAdapter<Pair<String, String>>() {
    override fun getLayoutId(position: Int, obj: Pair<String, String>) = R.layout.layout_item_two
    override fun getViewHolder(view: View, viewType: Int) = ItemTwoVH(view)
}

class ItemTwoVH(view: View) : BaseVH<Pair<String, String>>(view) {
    override fun bind(item: Pair<String, String>, position: Int, onItemPressed: ((View, Pair<String, String>, Int) -> Unit)?) {
        super.bind(item, position, onItemPressed)
        view.txt_title.text = item.first
        view.txt_info.text = item.second
    }
}

class ItemThreeAdapter: BaseAdapter<String>() {
    override fun getLayoutId(position: Int, obj: String) = R.layout.layout_item_three
    override fun getViewHolder(view: View, viewType: Int) = ItemThreeVH(view)
}

class ItemThreeVH(view: View) : BaseVH<String>(view) {}
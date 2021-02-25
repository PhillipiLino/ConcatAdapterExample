package com.phillipilino.concatadapterexample

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import com.phillipilino.concatadapterexample.adapters.*
import com.phillipilino.concatadapterexample.viewHolders.BalanceItem
import com.phillipilino.concatadapterexample.viewHolders.FinancesItem
import com.phillipilino.concatadapterexample.viewHolders.TransferItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapterTop = ItemFinancesTopAdapter()
        val adapterBalance = ItemBalanceAdapter()
        val adapterFinances = ItemFinancesAdapter()
        val adapterTransfers = ItemTransferAdapter(this)
        val adapterDescription = ItemDescriptionAdapter()
        val adapterButton = ItemButtonAdapter()

        val concatAdapter = ConcatAdapter(adapterTop, adapterBalance, adapterFinances,
            adapterTransfers, adapterDescription, adapterButton)
        recycler.adapter = concatAdapter

        val balance = listOf(
            BalanceItem("Saldo Disponível", 2350324324.12),
            BalanceItem("Saldo anterior", 2350.12),
            BalanceItem("Saldo atual", 2350.12),
            BalanceItem("Limite (+)", 2350.12),
            BalanceItem("Saldo bloqueado (-)", 2350.12),
            BalanceItem("Valor bloqueado (-)", 2350.12),
        )

        val finances = listOf(
            FinancesItem("18/04/1995", "Fundos", "Resgate Total", 2350.12),
            FinancesItem("18/04/1995", "Fundos", "Resgate Parcial", 23501.12),
            FinancesItem("18/04/1995", "Fundos", "Resgate Total", 2350323.12),
            FinancesItem("18/04/1995", "Fundos", "Resgate Total", 23502.12)
        )

        val transfers = listOf(
            TransferItem("18/04/1995", "TRANSF. MESMA TITULARIADADE", "Informações do TED D", 128.99),
            TransferItem("18/04/1995", "TRANSF. MESMA TITULARIADADE", "Informações do TED D", 128121.99),
            TransferItem("18/04/1995", "TRANSF. MESMA TITULARIADADE", "", -1243.99),
            TransferItem("18/04/1995", "TRANSF. MESMA TITULARIADADE", "Informações do TED D", -12328.99),
            TransferItem("18/04/1995", "TRANSF. MESMA", "", 12318.99),
            TransferItem("18/04/1995", "TRANSF. MESMA", "Informações do TED D", -12238.99)
        )

        val buttons = listOf(
            "Juros Acumulado no Período",
            "Taxa de Juros Efetivada (ao mês)"
        )

        adapterTop.init { _, item, _ ->
            Log.d("RADIO_CLICKED", "$item dias")
        }

        adapterBalance.loadItems(balance, null)
        adapterFinances.loadItems(finances, null)
        adapterTransfers.loadItems(transfers, null)
        adapterDescription.loadItems(listOf("Tarifa no valor de <b>R\$ 000,00</b>, cobrada pela disponibilização do limite de crédito, apurada de acordo com a normativa 4765 do Banco Central do Brasil ou conforme política de cobrança de tarifa da Instituição Financeira. "), null)
        adapterButton.loadItems(buttons) { _, title, position ->
            Log.d("BTN_CLICKED", title)
        }
    }
}

fun View.setVisible(visible: Boolean = true) {
    visibility = if (visible) VISIBLE else GONE
}
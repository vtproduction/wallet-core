package com.trustwallet.core.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import wallet.core.jni.CoinType
import wallet.core.jni.HDWallet

class MainActivity : AppCompatActivity() {

    init {
        System.loadLibrary("TrustWalletCore")
    }

    private val seedPhrase = "ripple scissors kick mammal hire column oak again sun offer wealth tomorrow wagon turn fatal"
    private val passphrase = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 'Import' a wallet
        val wallet = HDWallet(seedPhrase, passphrase)
        Log.d(Companion.TAG,"Mnemonic: \n${wallet.mnemonic()}")

        // Ethereum example
        val coinEth: CoinType = CoinType.ETHEREUM
        // Get the default address
        val addressEth = wallet.getAddressForCoin(coinEth)
        Log.d(Companion.TAG,"Default ETH address: \n$addressEth")
        Log.d(Companion.TAG,"Default TOMO address: ${wallet.getAddressForCoin(CoinType.TOMOCHAIN)}")
        Log.d(Companion.TAG, "Default ETH address: \n${wallet.getAddressForCoin(CoinType.TOMOCHAINTESTNET)}")

    }

    companion object {
        private const val TAG = "MainActivityTAGGG"
    }
}

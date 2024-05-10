package net.astrovel.traineechallenge.account.utils

class Constants {

    companion object{
        private const val URL_API_BASE="/api"
        private const val URL_API_VERSION="/v1"
        private const val URL_BASE=URL_API_BASE+URL_API_VERSION
        //Endpoint API Accounts
        const val URL_BASE_ACCOUNTS="$URL_BASE/accounts"
        //Endpoint API Transactions
        const val URL_BASE_TRANSACTIONS="$URL_BASE/transactions"
        //Endpoint API Transactions
        const val URL_BASE_MARKETS="$URL_BASE/markets"
    }
}
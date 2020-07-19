package ru.okcode.icalc

import android.app.Application
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import com.yandex.metrica.push.YandexMetricaPush

class CalcApp : Application() {
    override fun onCreate() {
        super.onCreate()

        val config: YandexMetricaConfig =
            YandexMetricaConfig.newConfigBuilder(getString(R.string.yandex_key_id)).build()
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
        YandexMetricaPush.init(applicationContext)
    }
}
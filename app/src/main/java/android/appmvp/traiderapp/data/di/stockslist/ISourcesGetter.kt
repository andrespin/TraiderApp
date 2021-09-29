package android.appmvp.traiderapp.data.di.stockslist

import android.content.res.XmlResourceParser

interface ISourcesGetter {
    fun getSources(): XmlResourceParser
}
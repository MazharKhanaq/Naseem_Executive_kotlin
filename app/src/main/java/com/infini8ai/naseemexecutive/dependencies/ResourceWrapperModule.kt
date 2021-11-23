package com.infini8ai.naseemexecutive.dependencies



import com.infini8ai.naseemexecutive.data.impl.IRes
import com.infini8ai.naseemexecutive.data.impl.ResImpl
import com.infini8ai.naseemexecutive.data.prefs.IPref
import com.infini8ai.naseemexecutive.data.prefs.PrefImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ResourceWrapperModule {

    @Singleton
    @Binds
    abstract fun bindResImpl(resImpl: ResImpl): IRes

    @Singleton
    @Binds
    abstract fun bindPrefImpl(prefImpl: PrefImpl): IPref
}
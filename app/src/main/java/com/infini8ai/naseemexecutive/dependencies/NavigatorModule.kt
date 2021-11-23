package com.infini8ai.naseemexecutive.dependencies

import com.infini8ai.naseemexecutive.data.loginImpl.LoginManager
import com.infini8ai.naseemexecutive.data.loginImpl.LoginMangerImpl
import com.infini8ai.naseemexecutive.data.signupImpl.SignUpManager
import com.infini8ai.naseemexecutive.data.signupImpl.SignUpManagerImpl
import com.infini8ai.naseemexecutive.navigator.Navigator
import com.infini8ai.naseemexecutive.navigator.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigatorModule {

    @Binds
    abstract fun bindNavigatorImpl(navigatorImpl: NavigatorImpl): Navigator

    @Binds
    abstract fun binLoginMangerImpl(loginMangerImpl: LoginMangerImpl): LoginManager


    @Binds
    abstract fun binSignUpMangerImpl(SignUpManangerImpl: SignUpManagerImpl): SignUpManager


}

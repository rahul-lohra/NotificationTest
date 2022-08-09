package com.rahul.notificationstest.di.modules

import okhttp3.Interceptor
import javax.inject.Inject

class InterceptorFactory @Inject constructor(val interceptors: MutableSet<Interceptor>) {
}
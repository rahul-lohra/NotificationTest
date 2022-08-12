package com.rahul.notificationstest.feature.search.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rahul.notificationstest.feature.search.data.datasource.DummyDataProvider
import com.rahul.notificationstest.feature.search.data.datasource.LocalDataSource
import com.rahul.notificationstest.feature.search.data.datasource.PhotosPagingSource
import com.rahul.notificationstest.feature.search.data.datasource.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val dummyDataProvider: DummyDataProvider,
) {

    suspend fun getDummyData(): Flow<String> {
        return dummyDataProvider.getData()
    }

    fun getPagingPhotos(): Flow<PagingData<String>> = remoteDataSource.getPagingPhotos()
}
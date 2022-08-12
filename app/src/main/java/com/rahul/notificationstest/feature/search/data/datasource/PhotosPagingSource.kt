package com.rahul.notificationstest.feature.search.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rahul.notificationstest.feature.search.data.apis.unsplash.UnsplashApi
import javax.inject.Inject

class PhotosPagingSource @Inject constructor(val api: UnsplashApi) : PagingSource<Int, String>() {

    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPageIndex = state.pages.indexOf(state.closestPageToPosition(anchorPosition))
            state.pages.getOrNull(anchorPageIndex + 1)?.prevKey ?: state.pages.getOrNull(
                anchorPageIndex - 1
            )?.nextKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        val currentKey: Int = params.key ?: 0
        try {
            val response = api.getPhotos(currentKey)
            val smallImageUrls = response.filter { it.urls?.small?.isNotEmpty() == true }.map {
                it.urls?.small!!
            }
            return LoadResult.Page(
                data = smallImageUrls,
                prevKey = if (currentKey == 0) null else currentKey - 1,
                nextKey = currentKey + 1
            )
        } catch (ex: Exception) {
            return LoadResult.Error(ex)
        }
    }
}
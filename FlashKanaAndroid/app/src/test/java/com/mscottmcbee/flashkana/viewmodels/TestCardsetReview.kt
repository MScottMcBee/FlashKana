package com.mscottmcbee.flashkana.viewmodels

import com.mscottmcbee.flashkana.application.fkModules
import com.mscottmcbee.flashkana.model.FKRepository
import com.mscottmcbee.flashkana.model.Repository
import com.mscottmcbee.flashkana.model.TestRepository
import com.mscottmcbee.flashkana.model.dataobjects.CardSet
import com.mscottmcbee.flashkana.ui.cardreview.CardsetReviewViewModel
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Before
import org.koin.android.ext.android.startKoin
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.get
import org.koin.test.KoinTest
import org.mockito.Mockito
import org.mockito.Mockito.mock
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.BeforeClass
import org.junit.Rule
import org.koin.standalone.StandAloneContext.loadKoinModules
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class TestCardsetReview() : KoinTest {

    lateinit var model: CardsetReviewViewModel

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var repo: Repository

    init {
        loadKoinModules(listOf(module {
            viewModel(override=true) { (id: String) -> CardsetReviewViewModel(id, get()) }
            single(override=true) { TestRepository() as Repository }
        }))

        repo = get()
    }


    @Test
    fun testaaahhh() {

        model = CardsetReviewViewModel("a", repo)
        assertEquals("hello", model.getCardSetTitle())
    }

    @Test
    fun `buughghg`() {

        model = CardsetReviewViewModel("b", repo)
        assertEquals("Honk", model.getCardSetTitle())
    }
}

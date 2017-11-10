package com.rousci.androidapp.widgetnote.viewPresenter.editNote

import android.text.Editable
import android.view.MenuItem
import android.widget.EditText
import com.rousci.androidapp.widgetnote.BuildConfig
import com.rousci.androidapp.widgetnote.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.mockito.Mockito
import org.mockito.Mockito.*

/**
 * Created by rousci on 17-11-10.
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, buildDir = "app/build")
class PresenterTest{
    val editNote = mock(EditNote::class.java)
    val item = mock(MenuItem::class.java)
    val editText = mock(EditText::class.java)
    val text = mock(Editable::class.java)
    val dataSelect = "dataSelect"
    @Before
    fun initFunc(){
        Mockito.`when`(editNote.editText).thenReturn(editText)
        Mockito.`when`(editText.text).thenReturn(text)
        Mockito.`when`(editNote.dataSelect).thenReturn(dataSelect)
    }

    @Test(expected = NullPointerException::class)
    fun testFinish(){
        finishPR(editNote)
        verify(editNote).dataSelect
        verify(editNote).editText
        verify(editText).text
    }

    @Test
    fun onRecoverySelect(){
        Mockito.`when`(item.itemId).thenReturn(R.id.recovery)
        onItemSelectPR(item, editNote)
        verify(item).itemId
        verify(editNote).editText
        verify(editText).setText(dataSelect)
    }

    @Test(expected = NullPointerException::class)
    fun onDelSelect(){
        Mockito.`when`(item.itemId).thenReturn(R.id.del)
        onItemSelectPR(item, editNote)
        verify(editNote).finish()
    }

    @Test
    fun onHomeSelect(){
        Mockito.`when`(item.itemId).thenReturn(android.R.id.home)
        onItemSelectPR(item, editNote)
        verify(editNote).finish()
    }


}
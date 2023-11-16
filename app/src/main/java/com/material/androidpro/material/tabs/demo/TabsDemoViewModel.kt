package com.material.androidpro.material.tabs.demo

import android.content.Context
import android.widget.RadioGroup
import androidx.core.content.ContextCompat
import androidx.databinding.ObservableBoolean
import com.material.androidpro.R
import com.google.android.material.tabs.TabLayout

class TabsDemoViewModel(private val mContext: Context, private val mTabLayout: TabLayout) {

    @JvmField
    val isFixed = ObservableBoolean(true)

    @JvmField
    val isScrollable = ObservableBoolean(false)

    @JvmField
    val isTextOnly = ObservableBoolean(true)

    @JvmField
    val isTextWithIcon = ObservableBoolean(false)

    @JvmField
    val isIconLeft = ObservableBoolean(false)

    @JvmField
    val isIconTop = ObservableBoolean(false)

    @JvmField
    val isIconRadioGroupEnable = ObservableBoolean(false)

    init {
        addTabs()
    }

    val modeRadioGroupListener = RadioGroup.OnCheckedChangeListener { radioGroup, id ->
        when(id) {
            R.id.fixed -> {
                isFixed.set(true)
                isScrollable.set(false)
                mTabLayout.tabMode = TabLayout.MODE_FIXED
            }
            R.id.scrollable -> {
                isFixed.set(false)
                isScrollable.set(true)
                mTabLayout.tabMode = TabLayout.MODE_SCROLLABLE
            }
        }
        addTabs()
    }

    val textIconRadioGroupListener = RadioGroup.OnCheckedChangeListener { radioGroup, id ->
        when(id) {
            R.id.textOnly -> {
                isTextOnly.set(true)
                isTextWithIcon.set(false)

                isIconRadioGroupEnable.set(false)
                isIconLeft.set(false)
                isIconTop.set(false)
            }
            R.id.textWithImage -> {
                mTabLayout.isInlineLabel = true
                isTextOnly.set(false)
                isTextWithIcon.set(true)

                isIconRadioGroupEnable.set(true)
                isIconLeft.set(true)
                isIconTop.set(false)
            }
        }
        addTabs()
    }

    val iconRadioGroupListener = RadioGroup.OnCheckedChangeListener { radioGroup, id ->
        when(id) {
            R.id.iconLeft -> {
                mTabLayout.isInlineLabel = true
            }
            R.id.iconTop -> {
                mTabLayout.isInlineLabel = false
            }
        }
        addTabs()
    }

    private fun addTabs() {
        mTabLayout.removeAllTabs()

        mTabLayout.addTab(getTab("Item One"), 0, true)
        mTabLayout.addTab(getTab("Item Two"), 1, false)
        mTabLayout.addTab(getTab("Item Three"), 2, false)

        if (isScrollable.get()) {
            mTabLayout.addTab(getTab("Item Four"), 3, false)
            mTabLayout.addTab(getTab("Item Five"), 4, false)
            mTabLayout.addTab(getTab("Item Six"), 5, false)
            mTabLayout.addTab(getTab("Item Seven"), 6, false)
            mTabLayout.addTab(getTab("Item Eight"), 7, false)
            mTabLayout.addTab(getTab("Item Nine"), 8, false)
            mTabLayout.addTab(getTab("Item Ten"), 9, false)
        }

    }

    private fun getTab(tabName: String): TabLayout.Tab {
        val tab: TabLayout.Tab = mTabLayout.newTab()
        tab.text = tabName
        if (isTextWithIcon.get()) {
            tab.icon = ContextCompat.getDrawable(mContext, R.drawable.ic_home)
        }
        return tab
    }

}
package com.material.androidpro.material.menus.demo

import android.annotation.SuppressLint
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.annotation.MenuRes
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.widget.ListPopupWindow
import androidx.appcompat.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.databinding.FragmentMenusDemoBinding
import com.material.sharedcode.utils.AppUtils

class MenusDemoFragment : Fragment() {

    private val ICON_MARGIN = 16

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentMenusDemoBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_menus_demo, container, false
        )

        binding.menu.setOnClickListener { showMenu(it, R.menu.popup_menu) }

        binding.menuImage.setOnClickListener { showMenuImage(it, R.menu.popup_menu_image) }

        binding.customMenu.setOnClickListener { listPopupWindow(it) }

        setAutoCompleteTextViewAdapter(binding.autoCompleteTextView)

        return binding.root
    }

    private fun showMenu(v: View, @MenuRes menuRes: Int) {
        val popup = PopupMenu(requireContext(), v)
        popup.menuInflater.inflate(menuRes, popup.menu)

        popup.setOnMenuItemClickListener { item ->
            AppUtils.showToast(requireContext(), item.toString(), Toast.LENGTH_SHORT)
            false
        }
        popup.setOnDismissListener {
            // Respond to popup being dismissed.
        }

        popup.show()
    }


    @SuppressLint("RestrictedApi")
    private fun showMenuImage(v: View, @MenuRes menuRes: Int) {
        val popup = PopupMenu(requireContext(), v)
        popup.menuInflater.inflate(menuRes, popup.menu)

        if (popup.menu is MenuBuilder) {
            val menuBuilder = popup.menu as MenuBuilder
            menuBuilder.setOptionalIconsVisible(true)
            for (item in menuBuilder.visibleItems) {
                val iconMarginPx =
                    TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, ICON_MARGIN.toFloat(), resources.displayMetrics
                    )
                        .toInt()
                if (item.icon != null) {
                    item.icon = InsetDrawable(item.icon, iconMarginPx, 0, iconMarginPx, 0)
                }
            }
        }

        popup.setOnMenuItemClickListener { item ->
            AppUtils.showToast(requireContext(), item.toString(), Toast.LENGTH_SHORT)
            false
        }

        popup.show()
    }

    private fun listPopupWindow(view: View) {
        val listPopupWindow = ListPopupWindow(requireContext(), null, androidx.appcompat.R.attr.listPopupWindowStyle)
        listPopupWindow.anchorView = view

        val items = listOf("Item 1", "Item 2", "Item 3", "Item 4")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_popup_window_item, R.id.text, items)
        listPopupWindow.setAdapter(adapter)

        listPopupWindow.setOnItemClickListener { parent: AdapterView<*>?, v: View?, position: Int, id: Long ->
            AppUtils.showToast(requireContext(), items[position], Toast.LENGTH_SHORT)
            listPopupWindow.dismiss()
        }

        listPopupWindow.show()
    }

    private fun setAutoCompleteTextViewAdapter(view: AutoCompleteTextView) {

        val items = listOf("Item 1", "Item 2", "Item 3", "Item 4")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_popup_window_item, R.id.text, items)

        view.setAdapter(adapter)
    }

}
package com.material.androidpro.material.checkboxes.compose.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.fragment.app.Fragment
import com.material.androidpro.ui.Dimens

class CheckboxComposeDemoFragment : Fragment() {

    private lateinit var mVm: CheckboxComposeDemoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                mVm = CheckboxComposeDemoViewModel()
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    SimpleCheckbox()
                    EnabledCheckbox()
                    DisabledCheckbox()
                    ColouredCheckbox()
                    CheckedCheckbox()
                    LabelledCheckbox()
                    GroupedCheckbox(
                        mItemsList = listOf(
                            "Group Checkbox1",
                            "Group Checkbox2",
                            "Group Checkbox3"
                        )
                    )
                }
            }
        }
    }

    @Composable
    fun SimpleCheckbox() {
        val isChecked = remember { mutableStateOf(false) }

        Checkbox(checked = isChecked.value, onCheckedChange = { isChecked.value = it })
    }

    @Composable
    fun DisabledCheckbox() {
        val isChecked = remember { mutableStateOf(false) }

        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },
            enabled = false
        )
    }

    @Composable
    fun EnabledCheckbox() {
        val isChecked = remember { mutableStateOf(false) }

        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },
            enabled = true
        )
    }

    @Composable
    fun ColouredCheckbox() {
        val isChecked = remember { mutableStateOf(false) }

        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },
            enabled = true,
            colors = CheckboxDefaults.colors(Color.Blue)
        )
    }

    @Composable
    fun CheckedCheckbox() {
        val isChecked = remember { mutableStateOf(true) }

        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },
            enabled = true,
            colors = CheckboxDefaults.colors(Color.Blue)
        )
    }

    @Composable
    fun LabelledCheckbox() {

        ConstraintLayout {

            val (checkbox, text) = createRefs()
            val isChecked = remember { mutableStateOf(false) }

            Checkbox(
                checked = isChecked.value,
                onCheckedChange = { isChecked.value = it },
                enabled = true,
                colors = CheckboxDefaults.colors(Color.Green),
                modifier = Modifier
                    .constrainAs(checkbox) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(Dimens.dp_5)
            )

            Text(
                text = "Checkbox 1",
                modifier = Modifier
                    .constrainAs(text) {
                        start.linkTo(checkbox.end)
                        top.linkTo(checkbox.top)
                        bottom.linkTo(checkbox.bottom)
                    }, fontSize = Dimens.sp_18
            )
        }
    }

    @Composable
    fun GroupedCheckbox(mItemsList: List<String>) {

        mItemsList.forEach { items ->

            ConstraintLayout {

                val (checkbox, text) = createRefs()
                val isChecked = remember { mutableStateOf(false) }

                Checkbox(
                    checked = isChecked.value,
                    onCheckedChange = { isChecked.value = it },
                    enabled = true,
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Cyan,
                        uncheckedColor = Color.DarkGray,
                        checkmarkColor = Color.White
                    ),
                    modifier = Modifier
                        .constrainAs(checkbox) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .padding(Dimens.dp_5)
                )

                Text(
                    text = items,
                    modifier = Modifier
                        .constrainAs(text) {
                            start.linkTo(checkbox.end)
                            top.linkTo(checkbox.top)
                            bottom.linkTo(checkbox.bottom)
                        }
                )
            }

        }
    }

    @Composable
    @Preview
    private fun CheckboxDemoPreview() {
        mVm = CheckboxComposeDemoViewModel()
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            SimpleCheckbox()
            EnabledCheckbox()
            DisabledCheckbox()
            ColouredCheckbox()
            CheckedCheckbox()
            LabelledCheckbox()
            GroupedCheckbox(
                mItemsList = listOf(
                    "Group Checkbox1",
                    "Group Checkbox2",
                    "Group Checkbox3"
                )
            )
        }
    }

}
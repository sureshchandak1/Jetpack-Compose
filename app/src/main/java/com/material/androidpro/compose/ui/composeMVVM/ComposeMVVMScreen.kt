package com.material.androidpro.compose.ui.composeMVVM

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.material.androidpro.R
import com.material.androidpro.ui.Dimens
import com.material.composeui.widgets.GradientButton

@Composable
fun ComposeMVVMScreen() {

    val context = LocalContext.current

    val repository = ComposeMVVMRepository()
    val factory = ComposeMVVMViewModelFactory(repository)
    val vm = ComposeMVVMViewModel(repository)

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        val (
            logo, fullNameText, fullNameField, emailText, emailField,
            phoneNumberText, phoneNumberField, passwordText, passwordField,
            registerButton, loginText
        ) = createRefs()

        val startGuideline = createGuidelineFromStart(0.08f)
        val endGuideline = createGuidelineFromEnd(0.08f)
        val topGuideline = createGuidelineFromTop(Dimens.dp_16)
        val bottomGuideline = createGuidelineFromBottom(Dimens.dp_16)

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(Dimens.dp_100)
                .constrainAs(logo) {
                    top.linkTo(topGuideline, Dimens.dp_16)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = "Full Name", fontSize = Dimens.sp_14, color = Color(0xFF666376),
            modifier = Modifier.constrainAs(fullNameText) {
                start.linkTo(startGuideline)
                top.linkTo(logo.bottom, Dimens.dp_32)
            }
        )

        OutlinedTextField(
            value = vm.mRepository.fullName.value,
            onValueChange = { vm.mRepository.fullName.value = it },
            placeholder = { Text(text = "john@example.com") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.constrainAs(fullNameField) {
                top.linkTo(fullNameText.bottom, Dimens.dp_8)
                start.linkTo(startGuideline)
                end.linkTo(endGuideline)
                width = Dimension.fillToConstraints
            }
        )

        Text(
            text = "Email", fontSize = Dimens.sp_14, color = Color(0xFF666376),
            modifier = Modifier.constrainAs(emailText) {
                start.linkTo(startGuideline)
                top.linkTo(fullNameField.bottom, Dimens.dp_16)
            }
        )

        OutlinedTextField(
            value = vm.mRepository.email.value,
            onValueChange = { vm.mRepository.email.value = it },
            placeholder = { Text(text = "john@example.com") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.constrainAs(emailField) {
                top.linkTo(emailText.bottom, Dimens.dp_8)
                start.linkTo(startGuideline)
                end.linkTo(endGuideline)
                width = Dimension.fillToConstraints
            }
        )

        Text(
            text = "Phone number", fontSize = Dimens.sp_14, color = Color(0xFF666376),
            modifier = Modifier.constrainAs(phoneNumberText) {
                start.linkTo(startGuideline)
                top.linkTo(emailField.bottom, Dimens.dp_16)
            }
        )

        OutlinedTextField(
            value = vm.mRepository.phoneNumber.value,
            onValueChange = { vm.mRepository.phoneNumber.value = it },
            placeholder = { Text(text = "+6122284424") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.constrainAs(phoneNumberField) {
                top.linkTo(phoneNumberText.bottom, Dimens.dp_8)
                start.linkTo(startGuideline)
                end.linkTo(endGuideline)
                width = Dimension.fillToConstraints
            }
        )

        Text(
            text = "Password", fontSize = Dimens.sp_14, color = Color(0xFF666376),
            modifier = Modifier.constrainAs(passwordText) {
                start.linkTo(startGuideline)
                top.linkTo(phoneNumberField.bottom, Dimens.dp_16)
            }
        )

        OutlinedTextField(
            value = vm.mRepository.password.value,
            onValueChange = { vm.mRepository.password.value = it },
            placeholder = { Text(text = "**********") },
            visualTransformation = if (vm.mRepository.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            trailingIcon = {
                val image: ImageVector = if (vm.mRepository.passwordVisible)
                    ImageVector.vectorResource(id = R.drawable.ic_visibility)
                else ImageVector.vectorResource(id = R.drawable.ic_visibility_off)

                val description = if (vm.mRepository.passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = {vm.mRepository.passwordVisible = !vm.mRepository.passwordVisible}){
                    Icon(imageVector  = image, description)
                }
            },
            modifier = Modifier.constrainAs(passwordField) {
                top.linkTo(passwordText.bottom, Dimens.dp_8)
                start.linkTo(startGuideline)
                end.linkTo(endGuideline)
                width = Dimension.fillToConstraints
            }
        )

        GradientButton(
            text = "Register", textColor = Color.White, gradient = Brush.horizontalGradient(
                colors = listOf(Color(0xFF7662FA), Color(0xFF38B6FF))
            ),
            modifier = Modifier.constrainAs(registerButton) {
                top.linkTo(passwordField.bottom, Dimens.dp_30)
                start.linkTo(startGuideline)
                end.linkTo(endGuideline)
                width = Dimension.fillToConstraints
            }
        ) {

        }

        val loginString = "Login"
        val annotatedString = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color(0xFF767484))) {
                append("Have an account? ")
            }
            withStyle(style = SpanStyle(color = Color(0xFF000000), fontStyle = FontStyle.Normal)) {
                pushStringAnnotation(tag = loginString, annotation = loginString)
                append(loginString)
            }
        }
        ClickableText(text = annotatedString, onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.let { span ->
                    Toast.makeText(context, span.item, Toast.LENGTH_SHORT).show()
                }
        }, modifier = Modifier.constrainAs(loginText) {
            top.linkTo(registerButton.bottom, Dimens.dp_30)
            start.linkTo(startGuideline)
            end.linkTo(endGuideline)
        })

    }
}

@Preview
@Composable
fun WaterBottlePreview() {
    Surface {
        ComposeMVVMScreen()
    }
}
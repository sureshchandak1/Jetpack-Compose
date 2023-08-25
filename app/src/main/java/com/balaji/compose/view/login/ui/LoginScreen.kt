package com.balaji.compose.view.login.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.balaji.compose.R
import com.balaji.compose.ui.theme.ComposeTheme
import com.balaji.compose.ui.theme.dimens
import com.balaji.compose.view.login.LoginRepository
import com.balaji.compose.view.login.LoginViewModel
import com.balaji.compose.view.login.LoginViewModelFactory

@Composable
fun LoginScreen() {

    val context = LocalContext.current
    val repository = LoginRepository(context)
    val factory = LoginViewModelFactory(repository)
    val vm: LoginViewModel = viewModel(factory = factory)

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (title, loginET, passwordET, loginButton) = createRefs()

        Text(text = "Login",
            modifier = Modifier
                .padding(top = MaterialTheme.dimens.dp60)
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

        OutlinedTextField(
            label = { Text(text = stringResource(R.string.email_id)) },
            value = repository.emailId,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = MaterialTheme.dimens.dp16,
                    end = MaterialTheme.dimens.dp16,
                    top = MaterialTheme.dimens.dp40
                )
                .constrainAs(loginET) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            isError = repository.isEmailIdError,
            supportingText = {
                if (repository.isEmailIdError) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = repository.emailError,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            trailingIcon = {
                if (repository.isEmailIdError)
                    Icon(Icons.Filled.Close, "error", tint = MaterialTheme.colorScheme.error)
            },
            onValueChange = { repository.updateEmailId(it) }
        )

        OutlinedTextField(
            label = { Text(text = stringResource(R.string.password)) },
            value = repository.password,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = MaterialTheme.dimens.dp16,
                    end = MaterialTheme.dimens.dp16,
                    top = MaterialTheme.dimens.dp24
                )
                .constrainAs(passwordET) {
                    top.linkTo(loginET.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            isError = repository.isPasswordError,
            supportingText = {
                if (repository.isPasswordError) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = repository.passwordError,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            trailingIcon = {
                if (repository.isPasswordError)
                    Icon(Icons.Filled.Close, "error", tint = MaterialTheme.colorScheme.error)
            },
            onValueChange = {
                repository.updatePassword(it)
            }
        )

        Button(
            onClick = repository.loginClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = MaterialTheme.dimens.dp16,
                    end = MaterialTheme.dimens.dp16,
                    top = MaterialTheme.dimens.dp24
                )
                .constrainAs(loginButton) {
                    top.linkTo(passwordET.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
            Text(text = stringResource(R.string.login))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ComposeTheme {
        LoginScreen()
    }
}
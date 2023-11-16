package com.material.androidpro.material.buttons.compose.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.ui.Dimens

class ButtonComposeLoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                loginUI()
            }
        }
    }

    private fun login(userId: String, password: String) {
        if (userId == "Jks" && password == "12345") {
            Toast.makeText(context, "logged!!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Wrong credential", Toast.LENGTH_SHORT).show()
        }
    }

    @Composable
    private fun loginUI() {

        val userName = remember { mutableStateOf("Jks") }
        val password = remember { mutableStateOf("12345") }

        Surface(color = MaterialTheme.colors.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        PaddingValues(
                            top = Dimens.dp_40,
                            start = Dimens.dp_20,
                            end = Dimens.dp_20
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo", modifier = Modifier
                        .fillMaxWidth()
                        .size(Dimens.dp_100),
                    alignment = Alignment.Center
                )

                Text(
                    text = "Compose Login",
                    color = colorResource(id = R.color.secondary),
                    fontSize = Dimens.sp_30,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingValues(top = Dimens.dp_30)),
                    textAlign = TextAlign.Center
                )

                OutlinedTextField(value = userName.value, onValueChange = {
                    userName.value = it
                }, leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "Person")
                }, label = {
                    Text(text = "Username")
                }, placeholder = {
                    Text(text = "Enter User ID")
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingValues(top = Dimens.dp_40))
                )

                OutlinedTextField(value = password.value, onValueChange = {
                    password.value = it
                }, leadingIcon = {
                    Icon(Icons.Default.Info, contentDescription = "Password")
                }, label = {
                    Text(text = "Password")
                }, placeholder = {
                    Text(text = "Enter Password")
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingValues(top = Dimens.dp_20))
                )

                OutlinedButton(
                    onClick = { login(userName.value, password.value) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingValues(top = Dimens.dp_40)),
                    border = BorderStroke(Dimens.dp_1, colorResource(id = R.color.secondary)),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(text = "Login", color = colorResource(id = R.color.secondary), fontWeight = FontWeight.Bold)
                }
            }
        }
    }

    @Preview
    @Composable
    private fun DefaultPreview() {
        loginUI()
    }

}


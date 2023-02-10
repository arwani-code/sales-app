package com.arwani.ahmad.ui.add

import android.app.DatePickerDialog
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.arwani.ahmad.ui.components.TopBar
import java.util.*

@Composable
fun AddScreen(addViewModel: AddViewModel = hiltViewModel(), navHostController: NavHostController) {

    val mContext = LocalContext.current
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    val mCalendar = Calendar.getInstance()

    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()
    val mDate = remember { mutableStateOf("") }

    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYear, mMonth, mDay
    )

    Scaffold(topBar = { TopBar(canNavigate = false, title = "Add") }) { inner ->
        Column(modifier = Modifier.padding(inner)) {
            Column(
                modifier = Modifier
                    .height(400.dp)
                    .width(400.dp)
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                TextField(
                    value = addViewModel.partNo,
                    onValueChange = { addViewModel.partNo = it },
                    label = {
                        Text(text = "Part No")
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text
                    ),
                )
                TextField(
                    value = addViewModel.desc,
                    onValueChange = { addViewModel.desc = it },
                    label = {
                        Text(text = "Desc")
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text
                    ),
                )
                TextField(
                    value = addViewModel.batchNo,
                    onValueChange = { addViewModel.batchNo = it },
                    label = {
                        Text(text = "Batch No")
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    OutlinedButton(onClick = { mDatePickerDialog.show() }) {
                        Text(text = "Pilih Tanggal")
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(text = mDate.value)
                }
                TextField(
                    value = addViewModel.qtyName,
                    onValueChange = { addViewModel.qtyName = it },
                    label = {
                        Text(text = "Qty Opname")
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                )

                Button(modifier = Modifier.padding(top = 12.dp), onClick = {
                    if (addViewModel.partNo.isNotEmpty()
                        && addViewModel.batchNo.isNotEmpty()
                        && addViewModel.desc.isNotEmpty()
                        && addViewModel.qtyName.isNotEmpty()
                        && mDate.value.isNotEmpty()
                    ) {
                        addViewModel.addProduct(mDate.value)
                        Toast.makeText(mContext, "Sukses tambah produk", Toast.LENGTH_LONG).show()
                        navHostController.navigateUp()
                    }
                }) {
                    Text(text = "Add Product")
                }
            }
        }
    }
}
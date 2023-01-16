package com.xuannie.hdbcarpark.ui.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.xuannie.hdbcarpark.R
import com.xuannie.hdbcarpark.ui.HdbCarparkScreen
import kotlin.math.max


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FaultReportingChecklist(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var dropdownExpanded by remember { mutableStateOf(false) }
    var faultDescription = remember { mutableStateOf(TextFieldValue("")) }
    val options = listOf("Faded Parking Lines", "Faulty Ticketing Machines", "Uneven Ground", "Damaged Mirrors", "Others")
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        // Name of Reporter
        Text(
            text = "Fault Reporting Channel",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.SemiBold,
            modifier = modifier.padding(10.dp),
            maxLines = 1,
            textAlign = TextAlign.Start
        )

        // Fault Selection
        ExposedDropdownMenuBox(
            expanded = dropdownExpanded,
            onExpandedChange = {
                dropdownExpanded = !dropdownExpanded
            },
            modifier = modifier
                .fillMaxWidth()
                .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
        ) {
            TextField(
                readOnly = true,
                value = selectedOptionText,
                onValueChange = { },
                label = { Text("What issue would you like to report?", color = MaterialTheme.colors.primary) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = dropdownExpanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = modifier.fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = dropdownExpanded,
                onDismissRequest = {
                    dropdownExpanded = false
                },
                modifier = modifier.fillMaxWidth()
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            selectedOptionText = selectionOption
                            dropdownExpanded = false
                        }
                    ) {
                        Text(text = selectionOption)
                    }
                }
            }
        }
        
        Spacer(modifier = modifier.height(15.dp))

        TextField(
            value = faultDescription.value,
            onValueChange = {value ->
                faultDescription.value = value
            },
            label = {
                Text(
                "Provide more details if Others is selected.",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.primary
            ) },
            modifier = modifier
                .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .padding(3.dp)
        )

        // Image of Fault
        Spacer(modifier = modifier.height(5.dp))
        Text(
            text = "Please upload a snapshot of the fault as shown by the example below!! Your snapshot will replace the example image",
            style = MaterialTheme.typography.body2,
            maxLines = 2,
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = painterResource(id = R.drawable.fault_example),
            contentDescription = "Picture of a Fault in the Carpark",
            modifier = modifier
                .fillMaxWidth()
                .padding(15.dp)
        )
        
        // Upload Image Button & Submit Button
        Row {
            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "Upload Image",
                    style = MaterialTheme.typography.body2,
                )
            }

            Spacer(modifier = modifier.width(50.dp))

            Button(onClick = {
                navController.navigate(HdbCarparkScreen.Submission.name)
            }) {
                Text(
                    text = "Submit",
                    style = MaterialTheme.typography.body2,
                )
                
            }
            
        }

    }
}



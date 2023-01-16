package com.xuannie.hdbcarpark.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.math.max


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FaultReportingChecklist(
    modifier: Modifier = Modifier,

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
        ) {
            TextField(
                readOnly = true,
                value = selectedOptionText,
                onValueChange = { },
                label = { Text("What issue would you like to report?") },
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
        
        Spacer(modifier = modifier.height(5.dp))

        TextField(
            value = faultDescription.value,
            onValueChange = {value ->
                faultDescription.value = value
            },
            label = {
                Text(
                "Provide more details if Others is selected.",
                style = MaterialTheme.typography.body2,
                color = Color.Black
            ) },
            modifier = modifier
//                .border(2.dp, Color.Black)
                .fillMaxWidth()
                .padding(3.dp)
        )

    }
}



package com.xuannie.hdbcarpark.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.xuannie.hdbcarpark.ui.data.database.URADataRepository
import com.xuannie.hdbcarpark.ui.network.CarParkAvailability
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class AppViewModel(private val uraDataRepository: URADataRepository): ViewModel() {
    /**
     *  StateFlows to store the Data of API Calls
     */
    private val _carparkAvailUiState = MutableStateFlow(CarParkAvailability())
    val carparkAvailUiState: StateFlow<CarParkAvailability> = _carparkAvailUiState.asStateFlow()

    var carparkUiState: CarparkUiState by mutableStateOf(CarparkUiState.Loading)

    val _pointsUiState = MutableStateFlow(100)
    val pointsUiState: StateFlow<Int> = _pointsUiState.asStateFlow()


    /**
     * Function to get Carpark Availabilities
     */
    fun determineUserQuery(userInput: String) {
        carparkUiState = CarparkUiState.Loading
        viewModelScope.launch {
            carparkUiState = try {
                val listResult = uraDataRepository.getAvailableParkingLots()

                _carparkAvailUiState.value = CarParkAvailability(
                    status = listResult.status,
                    message = listResult.message,
                    carparkList = listResult.carparkList
                )
//                Log.d("DebugTag", "$listResult")
                CarparkUiState.Success(listResult)
            }
            catch (e: HttpException){
                CarparkUiState.Error
            }
            catch (e: IOException) {
                CarparkUiState.Error
            }
        }

    }



    // Factory Object to retrieve the singaporeBusRepository and pass it to the ViewModel
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as com.xuannie.hdbcarpark.HDBApplication)
                val uraDataRepository = application.container.uraDataRepository
                AppViewModel(uraDataRepository = uraDataRepository)
            }
        }
    }
}

// Simply saving the UiState as a Mutable State prevents us from saving the different status
// like Loading, Error, and Success
sealed interface CarparkUiState {
    data class Success(val cpAvailability: CarParkAvailability) : CarparkUiState
    // The 2 States below need not set new data and create new objects, which is why an object is sufficient for the web response
    object Error: CarparkUiState
    object Loading: CarparkUiState
    // Sealed Interface used instead of Interface to remove Else Branch
}
package com.molette.app.joursferies.presentation.home

import androidx.lifecycle.*
import com.molette.app.joursferies.core.common.enums.Zone
import com.molette.app.joursferies.data.db.models.toHoliday
import com.molette.app.joursferies.domain.models.Holiday
import com.molette.app.joursferies.domain.usecases.GetHolidaysUseCase
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.*

class HomeViewModel(
    private val getHolidaysUseCase: GetHolidaysUseCase
): ViewModel() {

    val zone: MutableLiveData<Zone> = MutableLiveData(Zone.METROPOLE)
    val holidays: LiveData<List<Holiday>> = getHolidaysUseCase.getHolidaysLocal(zone.value!!, getCurrentYear()).map { items -> items.map { it.toHoliday() } }.asLiveData()

    init {

        viewModelScope.launch {
            getHolidaysUseCase.getHolidaysRemote(Zone.METROPOLE, getCurrentYear())
        }
    }

    private fun getCurrentYear(): Int{
        val date = Date()
        val calendar = Calendar.getInstance()
        calendar.time = date
        return  calendar.get(Calendar.YEAR)
    }
}
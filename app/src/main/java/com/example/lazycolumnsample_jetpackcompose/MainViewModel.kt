package com.example.lazycolumnsample_jetpackcompose

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    /**
     * Don't expose the mutable list of tasks from outside the ViewModel.
     * Instead define _tasks and tasks. _tasks is internal and mutable inside the ViewModel.
     * tasks is public and read-only.
     */
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<TaskModel>
        get() = _tasks

    fun remove(item: TaskModel) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: TaskModel, checked: Boolean) =
        tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
}

private fun getWellnessTasks() = List(30) { i -> TaskModel(i, "Task # $i") }
